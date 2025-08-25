package tech.xiu.good;

// 上下文类，存储外部状态
class Tree {
    private double x;
    private double y;
    private TreeType type; // 引用享元对象

    public Tree(double x, double y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        // 调用享元对象的方法，并传入外部状态
        type.draw(x, y);
    }
}
