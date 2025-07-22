package tech.xiu.abstractFactory;

public class SmsFactory implements MessageFactory {
    public MessageSender createSender() { return new SmsSender(); }
    public MessageFormatter createFormatter() { return new SmsFormatter(); }
    public MessageLogger createLogger() { return new SmsLogger(); }
}
