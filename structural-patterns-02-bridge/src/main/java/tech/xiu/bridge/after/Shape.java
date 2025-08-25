package tech.xiu.bridge.after;

public abstract class Shape {

    Color color;

    public Shape(Color color) {
        this.color = color;
    }
    /**
     * 绘制形状
     */
   abstract void drawShape();

}
