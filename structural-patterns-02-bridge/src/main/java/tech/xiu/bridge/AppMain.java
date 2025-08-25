package tech.xiu.bridge;

import tech.xiu.bridge.after.BlueColor;
import tech.xiu.bridge.after.CircleShape;
import tech.xiu.bridge.after.RedColor;
import tech.xiu.bridge.after.SquareShape;

public class AppMain {


    /**
     * 假設我們在開發一個繪圖軟體，有不同的形狀 (Shape)，如 Circle (圓形)、Square (正方形)。
     * 同時，我們希望這些形狀可以用不同的顏色 (Color) 來繪製，如 Red (紅色)、Blue (藍色)。
     * @param args
     */
    public static void main(String[] args) {

        new CircleShape(new RedColor()).drawShape();

        new SquareShape(new BlueColor()).drawShape();

        new CircleShape(new BlueColor()).drawShape();

        new SquareShape(new RedColor()).drawShape();
    }
}
