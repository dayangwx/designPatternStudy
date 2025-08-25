package tech.xiu.decorate;


public class Espresso implements Beverage {
    @Override
    public String name() {
        return "Espresso";
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return 1.99; // 浓缩咖啡的基础价格
    }
}
