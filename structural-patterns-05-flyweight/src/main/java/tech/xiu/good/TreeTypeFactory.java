package tech.xiu.good;

import java.util.HashMap;
import java.util.Map;

// 享元工厂
class TreeTypeFactory {
    // 使用Map来缓存和复用享元对象
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String typeName) {
        TreeType type = treeTypes.get(typeName);
        if (type == null) {
            switch (typeName.toLowerCase()) {
                case "oak":
                    type = new OakTreeType();
                    break;
                // case "pine": type = new PineTreeType(); break; // 可以扩展其他树种
            }
            treeTypes.put(typeName, type);
        }
        return type;
    }
}
