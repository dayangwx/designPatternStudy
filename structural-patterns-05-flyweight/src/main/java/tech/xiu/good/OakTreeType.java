package tech.xiu.good;

// 具体的享元类 (Concrete Flyweight)
class OakTreeType implements TreeType {
    // 内部状态 (共享的) - 只会创建一次
    private final byte[] mesh = new byte[1024 * 1024]; // 1MB
    private final byte[] texture = new byte[5 * 1024 * 1024]; // 5MB

    public OakTreeType() {
        System.out.println("OakTreeType created: mesh and texture loaded into memory. (This should only happen once!)");
    }

    @Override
    public void draw(double x, double y) {
        // 使用共享的内部状态和传入的外部状态来完成绘制
        System.out.println("Drawing an Oak tree at (" + x + ", " + y + ")");
    }
}
