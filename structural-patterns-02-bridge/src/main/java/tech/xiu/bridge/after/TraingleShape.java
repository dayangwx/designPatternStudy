package tech.xiu.bridge.after;

public class TraingleShape extends Shape {

    public TraingleShape(Color color) {
        super(color);
    }

    @Override
    void drawShape() {
        System.out.print("Drawing Triangle Shape with ");
        color.drawColor();
    }
}
