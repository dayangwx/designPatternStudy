package tech.xiu.abstractFactory;

public class EmailAlertFormatter implements AlertFormatter {
    public String format(String rawMessage, String level) {
        return "[告警等级：" + level + "] " + rawMessage;
    }
}
