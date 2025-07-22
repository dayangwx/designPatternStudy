package tech.xiu.factoryMethod;

public class MysqlDBConnectFactory extends AbstractConnectDBFactory{
    @Override
    public DataBaseConnect createDBConnect() {
        return new MysqlDBConnect("mysqlUser", "mysqlDriver");
    }
}
