package tech.xiu.simpleFactory;

public class MainApp {

    public static void main(String[] args) {
        DataBaseConnect mysql = ConnectDBFactory.getConnectDB("mysql");
        mysql.connect();

        DataBaseConnect azure = ConnectDBFactory.getConnectDB("azure");
        azure.connect();

    }
}
