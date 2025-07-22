package tech.xiu.simpleFactory;

public class MysqlDBConnect extends DataBaseConnect{
    private String username;
    private String driver;

    public MysqlDBConnect(String username, String driver) {
        this.username = username;
        this.driver = driver;
    }

    @Override
    public void connect() {
        System.out.println("Connecting to database with " + username + " for " + driver);
    }
}
