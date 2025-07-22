package tech.xiu.abstractFactory;

public class EmailAlertSender implements AlertSender {
    public void sendAlert(String message, String level) {
        System.out.println("发送告警邮件：等级[" + level + "] 内容：" + message);
    }
}



