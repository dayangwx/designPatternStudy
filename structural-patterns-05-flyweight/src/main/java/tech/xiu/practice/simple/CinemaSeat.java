package tech.xiu.practice.simple;

public class CinemaSeat implements Seat {

    private final String state;

    private final String color;

    private final String icon;

    public CinemaSeat(String state, String color, String icon) {
        this.state = state;
        this.color = color;
        this.icon = icon;
    }

    @Override
    public void location(double x, double y) {
        System.out.println("座位[" + x + "," +  y + "] 状态:" + state +
                " 颜色:" + color + " 图标:" + icon);
    }
}
