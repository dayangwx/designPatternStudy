package tech.xiu.abstractFactory;

public interface AlertFactory {
    AlertSender createAlertSender();
    AlertFormatter createAlertFormatter();
    AlertLogger createAlertLogger();
}
