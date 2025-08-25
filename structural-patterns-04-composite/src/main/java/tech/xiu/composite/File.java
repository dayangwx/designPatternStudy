package tech.xiu.composite;

// Leaf: 文件
public class File implements FileSystemNode {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        // 文件直接返回自身大小
        return size;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + "- " + name + " (" + size + "KB)");
    }
}
