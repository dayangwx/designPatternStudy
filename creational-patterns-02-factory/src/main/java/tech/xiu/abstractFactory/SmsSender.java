package tech.xiu.abstractFactory;

// SMS具体实现
public class SmsSender implements MessageSender {
    public void send(String message, String to) {
        System.out.println("发送短信到 " + to + ": " + message);
    }
}




