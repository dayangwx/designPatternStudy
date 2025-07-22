package tech.xiu.abstractFactory;

public class MessageService {
    private MessageFactory factory;

    public MessageService(MessageFactory factory) {
        this.factory = factory;
    }

    public void sendMessage(String rawMessage, String recipient) {
        String formatted = factory.createFormatter().format(rawMessage);
        factory.createSender().send(formatted, recipient);
        factory.createLogger().log(formatted, recipient);
    }
}
