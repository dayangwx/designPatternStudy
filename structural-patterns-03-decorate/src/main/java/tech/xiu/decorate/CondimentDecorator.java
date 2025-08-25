package tech.xiu.decorate;


// 必须是抽象类，因为我们不希望实例化一个没有具体名称的调料
public abstract class CondimentDecorator implements Beverage {
    // 每个装饰器都必须引用一个它所装饰的 Beverage 对象
    protected Beverage beverage;

    // 我们将 getDescription() 也定义为抽象的，强制子类实现
    @Override
    public abstract String getDescription();

//    public void addCondiment(Beverage beverage) {
//        System.out.println("add "+beverage.name()+" price: " + beverage.cost());
//    }
}
