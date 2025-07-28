package tech.xiu.builder;

public class XiaoMiBuilder extends AbstractPhoneBuilder {


    @Override
    public AbstractPhoneBuilder cpu(String cpu) {
        phone.cpu = cpu;
        return this;
    }

    @Override
    public AbstractPhoneBuilder memory(String memory) {
        phone.memory = memory;
        return this;
    }

    @Override
    public AbstractPhoneBuilder storage(String storage) {
        phone.storage = storage;
        return this;
    }

    @Override
    public AbstractPhoneBuilder camera(String camera) {
        phone.camera = camera;
        return this;
    }

}
