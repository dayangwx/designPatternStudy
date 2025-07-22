package tech.xiu.abstractFactory;

public class EmailAlertLogger implements AlertLogger {
    public void log(String formattedMessage, String level) {
        System.out.println("记录告警日志 → 等级: " + level + " 内容: " + formattedMessage);
    }
}
