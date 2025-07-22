package tech.xiu.factoryMethod;

public class AzureDBConnectFactory extends AbstractConnectDBFactory{
    @Override
    public DataBaseConnect createDBConnect() {
        return new AzureDBConnect("azureUser","azureDriver");
    }
}
