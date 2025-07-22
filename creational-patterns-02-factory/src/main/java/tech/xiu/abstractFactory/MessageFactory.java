package tech.xiu.abstractFactory;

public interface MessageFactory {
    MessageSender createSender();
    MessageFormatter createFormatter();
    MessageLogger createLogger();
}
