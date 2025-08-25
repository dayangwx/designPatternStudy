package tech.xiu.decorate;


public class CoffeeShop {
    public static void main(String[] args) {
        // 订一杯最基本的浓缩咖啡
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        // 现在，让我们来装饰它
        // 1. 先来一杯浓缩咖啡
        Beverage beverage2 = new Espresso();
        // 2. 用 Mocha 装饰它
        beverage2 = new Mocha(beverage2);
        // 3. 再用 Mocha 装饰它 (双份摩卡)
        beverage2 = new Mocha(beverage2);
        // 4. 最后加上奶泡
        beverage2 = new Whip(beverage2);

        System.out.println(beverage2.getDescription() + " $" + String.format("%.2f", beverage2.cost()));
    }
}
