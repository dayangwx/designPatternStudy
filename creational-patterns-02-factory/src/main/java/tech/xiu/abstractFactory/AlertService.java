package tech.xiu.abstractFactory;

public class AlertService {
    private final AlertFactory factory;

    public AlertService(AlertFactory factory) {
        this.factory = factory;
    }

    public void alert(String rawMessage, String level) {
        String formatted = factory.createAlertFormatter().format(rawMessage, level);
        factory.createAlertSender().sendAlert(formatted, level);
        factory.createAlertLogger().log(formatted, level);
    }
}
