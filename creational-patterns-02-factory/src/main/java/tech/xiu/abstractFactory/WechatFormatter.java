package tech.xiu.abstractFactory;

public class WechatFormatter implements MessageFormatter{
    @Override
    public String format(String message) {
        return "[wechat信息格式化]: " + message;
    }
}
