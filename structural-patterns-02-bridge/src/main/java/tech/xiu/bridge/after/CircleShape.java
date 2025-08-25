package tech.xiu.bridge.after;

public class CircleShape extends Shape {

    public CircleShape(Color color) {
        super(color);
    }

    @Override
    public void drawShape() {
        System.out.print("Drawing Circle Shape... ");
        color.drawColor();
    }
}
