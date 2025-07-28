package tech.xiu.util;

import org.apache.sshd.common.config.keys.FilePasswordProvider;
import org.apache.sshd.common.keyprovider.KeyPairProvider;
import org.apache.sshd.common.util.security.SecurityUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.TransportConfigCallback;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.transport.SshTransport;
import org.eclipse.jgit.transport.sshd.SshdSessionFactory;
import org.eclipse.jgit.transport.sshd.SshdSessionFactoryBuilder;
import org.eclipse.jgit.util.FS;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.GeneralSecurityException;
import java.security.KeyPair;

public class GitSshCloneCorrectedExample {

    private static final String REMOTE_URL = "git@github.com:dayangwx/springboot-employee.git";
    private static final String PRIVATE_KEY_CLASSPATH_RESOURCE = "/id_ed25519"; // 确保在 src/main/resources 下
    private static final String PASSPHRASE = null; // 如果您的私钥有密码，请在此处设置

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        File localPath = Files.createTempDirectory("jgit-clone-final-test").toFile();
        System.out.println("Cloning into: " + localPath.getAbsolutePath());

        // 为了能将InputStream传递两次（一次给loadKeyPairIdentities，一次可能给其他），先读入byte[]
        byte[] privateKeyBytes;
        try (InputStream in = GitSshCloneFinalExample.class.getResourceAsStream(PRIVATE_KEY_CLASSPATH_RESOURCE)) {
            if (in == null) {
                throw new IOException("Private key not found in classpath: " + PRIVATE_KEY_CLASSPATH_RESOURCE);
            }
            privateKeyBytes = in.readAllBytes();
        }

        // **【修正点 2】将 byte[] 包装成 InputStream 传递给 SecurityUtils**
        KeyPairProvider keyPairProvider;
        try (InputStream privateKeyStream = new ByteArrayInputStream(privateKeyBytes)) {
            FilePasswordProvider passwordProvider = (PASSPHRASE == null || PASSPHRASE.isEmpty())
                    ? FilePasswordProvider.EMPTY
                    : FilePasswordProvider.of(PASSPHRASE);

            Iterable<KeyPair> keyPairs = SecurityUtils.loadKeyPairIdentities(
                    null,
                    null,
                    privateKeyStream, // 使用 InputStream
                    passwordProvider
            );
            keyPairProvider = KeyPairProvider.wrap(keyPairs);
        }

        // **【修正点 1】先 build()，后 setKeyPairProvider()**
        SshdSessionFactoryBuilder builder = new SshdSessionFactoryBuilder()
                .setHomeDirectory(FS.DETECTED.userHome())
                .setSshDirectory(new File(FS.DETECTED.userHome(), ".ssh"));

        // 从构建器创建 SshdSessionFactory 实例
        SshdSessionFactory sshdSessionFactory = builder.build(null);

        // 在实例上设置 KeyPairProvider
        sshdSessionFactory.setKeyPairProvider(keyPairProvider);


        // 使用正确的 TransportConfigCallback
        TransportConfigCallback transportConfigCallback = transport -> {
            if (transport instanceof SshTransport) {
                SshTransport sshTransport = (SshTransport) transport;
                sshTransport.setSshSessionFactory(sshdSessionFactory);
            }
        };

        try {
            Git.cloneRepository()
                    .setURI(REMOTE_URL)
                    .setDirectory(localPath)
                    .setTransportConfigCallback(transportConfigCallback)
                    .setBranch(Constants.HEAD)
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
            deleteDirectory(localPath);
        }
    }

    private static void deleteDirectory(File directory) {
        if (!directory.exists()) {
            return;
        }
        File[] allContents = directory.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        if (directory.delete()) {
            System.out.println("Deleted: " + directory.getAbsolutePath());
        } else {
            System.err.println("Failed to delete: " + directory.getAbsolutePath());
        }
    }
}
