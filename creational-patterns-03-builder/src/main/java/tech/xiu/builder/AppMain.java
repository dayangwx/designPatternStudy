package tech.xiu.builder;

public class AppMain {

    public static void main(String[] args) {
        AbstractPhoneBuilder xiaoMiBuilder = new XiaoMiBuilder();
        xiaoMiBuilder = xiaoMiBuilder.cpu("骁龙888")
                .memory("8GB")
                .storage("128GB")
                .camera("108MP");
        Phone phone = xiaoMiBuilder.getPhone();
        System.out.println("小米手机配置：" + phone);
    }
}
