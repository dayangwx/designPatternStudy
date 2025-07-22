package tech.xiu.abstractFactory;

public class WechatFactory implements MessageFactory{

    @Override
    public MessageSender createSender() {
        return new WechatSender();
    }

    @Override
    public MessageFormatter createFormatter() {
        return new WechatFormatter();
    }

    @Override
    public MessageLogger createLogger() {
        return new WechatLogger();
    }
}
