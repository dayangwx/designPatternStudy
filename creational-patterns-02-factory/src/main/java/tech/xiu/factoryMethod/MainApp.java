package tech.xiu.factoryMethod;

public class MainApp {

    /**
     * Factory Method Pattern 工厂方法模式创建对象。
     * 在这个模式中，创建对象的过程被封装在一个工厂类中，客户端代码通过工厂类来获取对象，而不是直接使用构造函数。
     *
     * 这样符合了开闭原则（OCP），即对扩展开放，对修改关闭。
     * 但是会增加复杂度， 类的数量增加较多。
     * @param args
     */
    public static void main(String[] args) {
        AbstractConnectDBFactory azureDBConnectFactory = new AzureDBConnectFactory();
        DataBaseConnect azureDbConnect = azureDBConnectFactory.createDBConnect();
        azureDbConnect.connect();

        MysqlDBConnectFactory mysqlDBConnectFactory = new MysqlDBConnectFactory();
        DataBaseConnect mysqlDBConnect = mysqlDBConnectFactory.createDBConnect();
        mysqlDBConnect.connect();


    }
}
