package tech.xiu.abstractFactory;

public class EmailAlertFactory implements AlertFactory {
    private EmailAlertSender sender;
    private EmailAlertFormatter formatter;
        private EmailAlertLogger logger;

    public AlertSender createAlertSender() { return sender; }
    public AlertFormatter createAlertFormatter() { return formatter; }
    public AlertLogger createAlertLogger() { return logger; }
}
