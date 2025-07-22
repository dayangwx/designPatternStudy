package tech.xiu.abstractFactory;

public class SmsLogger implements MessageLogger {
    public void log(String message, String to) {
        System.out.println("短信发送日志：" + message + " -> " + to);
    }
}
