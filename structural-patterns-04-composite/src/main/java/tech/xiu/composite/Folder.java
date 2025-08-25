package tech.xiu.composite;

import java.util.ArrayList;
import java.util.List;

// Composite: 文件夹
public class Folder implements FileSystemNode {
    private String name;
    private List<FileSystemNode> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemNode node) {
        children.add(node);
    }

    public void remove(FileSystemNode node) {
        children.remove(node);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        // 文件夹的大小是其所有子节点大小的总和
        int totalSize = 0;
        for (FileSystemNode child : children) {
            totalSize += child.getSize(); // 递归调用
        }
        return totalSize;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + "+ " + name + " (size: " + getSize() + "KB)");
        // 递归打印子节点
        for (FileSystemNode child : children) {
            child.print(prefix + "  ");
        }
    }
}
