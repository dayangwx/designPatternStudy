package tech.xiu.abstractFactory;

public class WechatSender implements MessageSender{
    @Override
    public void send(String message, String to) {
        System.out.println("发送微信消息到 " + to + ": " + message);
    }
}
