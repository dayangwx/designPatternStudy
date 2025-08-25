package tech.xiu.decorate;


public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage; // 将被装饰者（可以是另一个装饰器）传入
    }

    @Override
    public String name() {
        return "Mocha";
    }

    @Override
    public String getDescription() {
        // 递归地调用，将自己的描述加上去
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        // 递归地调用，将自己的价格加上去
        return beverage.cost() + 0.20;
    }
}
