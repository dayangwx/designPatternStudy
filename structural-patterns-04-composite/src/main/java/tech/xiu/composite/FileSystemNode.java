package tech.xiu.composite;

// Component: 组件接口
public interface FileSystemNode {
    String getName();
    int getSize(); // 获取大小（KB）
    void print(String prefix); // 打印出结构
}
