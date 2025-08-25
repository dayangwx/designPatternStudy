package tech.xiu.good;


import java.util.ArrayList;
import java.util.List;

// 客户端：新版森林
public class ForestFlyweight {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(double x, double y, String typeName) {
        // 从工厂获取共享的享元对象
        TreeType type = TreeTypeFactory.getTreeType(typeName);
        // 创建上下文对象，存储外部状态
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }

    public static void main(String[] args) {
        ForestFlyweight forest = new ForestFlyweight();
        int numberOfTrees = 1_000_000;

        // 种植100万棵橡树
        for (int i = 0; i < numberOfTrees; i++) {
            forest.plantTree(Math.random() * 100, Math.random() * 100, "Oak");
        }

        System.out.println(numberOfTrees + " trees planted.");
        // forest.draw(); // 如果调用，会看到绘制信息

        // 内存分析:
        // OakTreeType 对象只被创建了 1 次。内存占用约为 6MB。
        // Tree 对象被创建了 1,000,000 次。每个对象包含2个double和1个引用，大约 24 bytes。
        // 总内存占用约为 6MB + (1,000,000 * 24 bytes) ≈ 30MB。
        // 相比之前的 6TB，内存效率天差地别！
    }
}
