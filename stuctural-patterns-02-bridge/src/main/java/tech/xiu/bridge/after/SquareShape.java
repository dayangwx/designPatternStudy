package tech.xiu.bridge.after;

public class SquareShape extends Shape {

    public SquareShape(Color color) {
        super(color);
    }

    @Override
    public void drawShape() {
        System.out.print("Drawing Square Shape ... ");
        color.drawColor();
    }
}
