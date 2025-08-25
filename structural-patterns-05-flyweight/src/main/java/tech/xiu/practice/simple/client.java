package tech.xiu.practice.simple;

public class client {

    public static void main(String[] args) {
        // 创建500个座位
        for (int row = 1; row <= 25; row++) {
            for (int col = 1; col <= 20; col++) {
                // 假设奇数列是已售，偶数列是可选
                String state = (col % 2 == 0) ? "available" : "sold";
                Seat seat = CinemaSeatFactory.getSeat(state);
                seat.location(row, col); // 外部状态 row,col
            }
        }
    }
}
