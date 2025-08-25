package tech.xiu.practice.simple;

import java.util.HashMap;
import java.util.Map;

public class CinemaSeatFactory {

    private static final Map<String, Seat> seatTypeMap = new HashMap<>();

    public static Seat getSeat(String state) {
        Seat seatType = seatTypeMap.get(state);
        if (seatType ==null) {
            switch (state.toLowerCase()) {
                case "available" -> seatTypeMap.put(state, new CinemaSeat("可选", "绿色", "√"));
                case "selected" -> seatTypeMap.put(state, new CinemaSeat("已选", "黄色", "★"));
                case "sold" -> seatTypeMap.put(state, new CinemaSeat("已售", "红色", "×"));
                case "reserved" -> seatTypeMap.put(state, new CinemaSeat("预留", "灰色", "-"));
                default -> throw new IllegalArgumentException("未知的座位状态: " + state);
            }
        }
        return seatTypeMap.get(state);
    }
}
