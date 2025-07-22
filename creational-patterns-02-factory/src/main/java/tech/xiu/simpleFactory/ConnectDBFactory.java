package tech.xiu.simpleFactory;

public class ConnectDBFactory {

    public static DataBaseConnect getConnectDB(String type) {
        if ("mysql".equalsIgnoreCase(type)) {
            return new MysqlDBConnect("muser", "jdbc.mysql");
        } else if ("azure".equalsIgnoreCase(type)) {
            return new AzureDBConnect("azureUser", "jdbc.azure");
        } else {
            throw new IllegalArgumentException("Unknown database type: " + type);
        }
    }
}
