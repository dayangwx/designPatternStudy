package tech.xiu.util;//package tech.xiu.util;
//
//import org.eclipse.jgit.api.Git;
//import org.eclipse.jgit.api.TransportConfigCallback;
//import org.eclipse.jgit.api.errors.GitAPIException;
//import org.eclipse.jgit.lib.Constants;
//import org.eclipse.jgit.transport.SshTransport;
//import org.eclipse.jgit.transport.Transport;
////import org.eclipse.jgit.transport.TransportConfigCallback;
//import org.eclipse.jgit.transport.sshd.SshdSessionFactory;
//import org.eclipse.jgit.transport.sshd.SshdSessionFactoryBuilder;
//import org.eclipse.jgit.util.FS;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.util.Collections;
//
//public class GitSshCloneExamplebak {
//
//    private static final String REMOTE_URL = "git@github.com:dayangwx/springboot-employee.git";
//    private static final String PRIVATE_KEY_CLASSPATH_RESOURCE = "/id_ed25519"; // 在 src/main/resources 下
//    private static final String PASSPHRASE = null; // 如果您的私钥有密码，请在此处设置
//
//    public static void main(String[] args) throws IOException {
//        // 创建一个临时目录用于克隆仓库
//        File localPath = Files.createTempDirectory("jgit-clone-test").toFile();
//        System.out.println("Cloning into: " + localPath.getAbsolutePath());
//
//        // 从 classpath 加载私钥内容
//        byte[] privateKeyBytes;
//        try (InputStream in = GitSshCloneExamplebak.class.getResourceAsStream(PRIVATE_KEY_CLASSPATH_RESOURCE)) {
//            if (in == null) {
//                throw new IOException("Private key not found in classpath: " + PRIVATE_KEY_CLASSPATH_RESOURCE);
//            }
//            privateKeyBytes = in.readAllBytes();
//        }
//
//        // 配置 SshdSessionFactory
//        SshdSessionFactory sshdSessionFactory = new SshdSessionFactoryBuilder()
//                .setHomeDirectory(FS.DETECTED.userHome())
//                .setSshDirectory(new File(FS.DETECTED.userHome(), ".ssh"))
//                .setDefaultIdentities(session -> Collections.singleton(
//                        SshdSessionFactory.createKeyPair(null, privateKeyBytes, PASSPHRASE != null ? PASSPHRASE.toCharArray() : null))
//                )
//                .build(null);
//
//        TransportConfigCallback transportConfigCallback = new TransportConfigCallback() {
//            @Override
//            public void configure(Transport transport) {
//                if (transport instanceof SshTransport) {
//                    SshTransport sshTransport = (SshTransport) transport;
//                    sshTransport.setSshSessionFactory(sshdSessionFactory);
//                }
//            }
//        };
//
//        try {
//            Git.cloneRepository()
//                    .setURI(REMOTE_URL)
//                    .setDirectory(localPath)
//                    .setTransportConfigCallback(transportConfigCallback)
//                    .setBranch(Constants.HEAD) // 可以指定特定分支
//                    .call();
//
//            System.out.println("Repository cloned successfully!");
//
//        } catch (GitAPIException e) {
//            System.err.println("Error cloning repository: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            // 清理临时目录
//            if (localPath.exists()) {
//                deleteDirectory(localPath);
//                System.out.println("Cleaned up temporary directory.");
//            }
//        }
//    }
//
//    private static void deleteDirectory(File directory) {
//        File[] allContents = directory.listFiles();
//        if (allContents != null) {
//            for (File file : allContents) {
//                deleteDirectory(file);
//            }
//        }
//        directory.delete();
//    }
//}
