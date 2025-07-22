package tech.xiu.factoryMethod;

public class AzureDBConnect extends DataBaseConnect {
    private String driver;
    private String username;



    public AzureDBConnect(String username, String driver) {
        this.username = username;
        this.driver = driver;
    }

    @Override
    public void connect() {
        System.out.println("Connecting to database with " + username + " for " + driver);
        // 连接 Azure 数据库的具体实现
    }

}
