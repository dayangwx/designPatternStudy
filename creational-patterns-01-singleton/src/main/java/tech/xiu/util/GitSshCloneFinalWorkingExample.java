package tech.xiu.util;

import org.apache.sshd.common.config.keys.FilePasswordProvider;
import org.apache.sshd.common.util.security.SecurityUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.TransportConfigCallback;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.SshTransport;
import org.eclipse.jgit.transport.sshd.SshdSessionFactory;
import org.eclipse.jgit.transport.sshd.SshdSessionFactoryBuilder;
import org.eclipse.jgit.util.FS;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.util.Comparator;

public class GitSshCloneFinalWorkingExample {

    private static final String REMOTE_URL = "git@github.com:dayangwx/springboot-employee.git";
    private static final String PRIVATE_KEY_CLASSPATH_RESOURCE = "/id_ed25519"; // 确保在 src/main/resources 下
    private static final String PASSPHRASE = null; // 如果您的私钥有密码，请在此处设置

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        // 创建一个临时目录用于克隆仓库
        Path localPath = Files.createTempDirectory("jgit-clone-final-working-test");
        System.out.println("Cloning into: " + localPath);

        // 1. 将私钥从 classpath 读入字节数组
        byte[] privateKeyBytes;
        try (InputStream in = GitSshCloneFinalWorkingExample.class.getResourceAsStream(PRIVATE_KEY_CLASSPATH_RESOURCE)) {
            if (in == null) {
                throw new IOException("Private key not found in classpath: " + PRIVATE_KEY_CLASSPATH_RESOURCE);
            }
            privateKeyBytes = in.readAllBytes();
        }

        // 2. 使用 SecurityUtils 从输入流中加载密钥对集合
        final Iterable<KeyPair> keyPairs;
        try (InputStream privateKeyStream = new ByteArrayInputStream(privateKeyBytes)) {
            FilePasswordProvider passwordProvider = (PASSPHRASE == null || PASSPHRASE.isEmpty())
                    ? FilePasswordProvider.EMPTY
                    : FilePasswordProvider.of(PASSPHRASE);

            // 这是从流中加载密钥对的正确方法
            keyPairs = SecurityUtils.loadKeyPairIdentities(
                    null,
                    null,
                    privateKeyStream,
                    passwordProvider
            );
        }

        // 3. 【最终修正】使用 setDefaultIdentities 方法注入预加载的密钥
        SshdSessionFactory sshdSessionFactory = new SshdSessionFactoryBuilder()
                .setHomeDirectory(FS.DETECTED.userHome())
                .setSshDirectory(new File(FS.DETECTED.userHome(), ".ssh"))
                // 当 JGit 需要 SSH 密钥时，它会调用这个 Lambda 表达式。
                // 我们直接返回已从内存加载的密钥对。
                .setDefaultIdentities(session -> keyPairs)
                .build(null);

        // 4. 配置 TransportConfigCallback
        TransportConfigCallback transportConfigCallback = transport -> {
            if (transport instanceof SshTransport) {
                SshTransport sshTransport = (SshTransport) transport;
                sshTransport.setSshSessionFactory(sshdSessionFactory);
            }
        };

        // 5. 执行克隆
        try {
            Git.cloneRepository()
                    .setURI(REMOTE_URL)
                    .setDirectory(localPath.toFile())
                    .setTransportConfigCallback(transportConfigCallback)
                    .call();

            System.out.println("Repository cloned successfully!");

        } catch (GitAPIException e) {
            System.err.println("Error cloning repository: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Cause: " + e.getCause().getMessage());
                e.getCause().printStackTrace();
            } else {
                e.printStackTrace();
            }
        } finally {
            // 清理
            if (Files.exists(localPath)) {
                //noinspection ResultOfMethodCallIgnored
                Files.walk(localPath)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
                System.out.println("Cleaned up temporary directory: " + localPath);
            }
        }
    }
}
