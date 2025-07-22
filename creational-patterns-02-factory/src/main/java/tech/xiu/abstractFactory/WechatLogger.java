package tech.xiu.abstractFactory;

public class WechatLogger implements MessageLogger {

    @Override
    public void log(String message, String to) {
        System.out.println("Wechat发送日志：" + message + " -> " + to);
    }
}
