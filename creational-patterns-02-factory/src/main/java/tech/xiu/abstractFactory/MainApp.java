package tech.xiu.abstractFactory;

public class MainApp {
    public static void main(String[] args) {
        MessageFactory factory = new SmsFactory(); // 可切换为 EmailFactory、WeChatFactory 等
        MessageService service = new MessageService(factory);
        service.sendMessage("你好，这是一条通知", "1234567890");

        System.out.println("--------------------------");

        WechatFactory wechatFactory = new WechatFactory();
        MessageService messageService = new MessageService(wechatFactory);
        messageService.sendMessage("你好，这是一条通知", "1234567890");
    }
}
