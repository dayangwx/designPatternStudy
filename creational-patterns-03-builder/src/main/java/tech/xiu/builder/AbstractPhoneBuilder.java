package tech.xiu.builder;

public abstract class AbstractPhoneBuilder {

    protected Phone phone;

    public AbstractPhoneBuilder() {
        this.phone = new Phone();
    }

    public abstract AbstractPhoneBuilder cpu(String cpu);

    public abstract AbstractPhoneBuilder memory(String memory);

    public abstract AbstractPhoneBuilder storage(String storage);

    public abstract AbstractPhoneBuilder camera(String camera);

    public Phone getPhone() {
        return phone;
    }
}
