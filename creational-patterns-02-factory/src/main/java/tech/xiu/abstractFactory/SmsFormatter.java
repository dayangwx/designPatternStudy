package tech.xiu.abstractFactory;

public class SmsFormatter implements MessageFormatter {
    public String format(String message) {
        return "[短信格式化]" + message;
    }
}
