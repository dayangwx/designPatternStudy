package tech.xiu.userCompositePattern;

import java.util.ArrayList;
import java.util.List;

interface FileSystemNode {
    void display(String indent);
}

class FileLeaf implements FileSystemNode {
    private String name;

    public FileLeaf(String name) {
        this.name = name;
    }

    public void display(String indent) {
        System.out.println(indent + "📄 " + name);
    }
}

class DirectoryComposite implements FileSystemNode {
    private String name;
    private List<FileSystemNode> children = new ArrayList<>();

    public DirectoryComposite(String name) {
        this.name = name;
    }

    public void add(FileSystemNode node) {
        children.add(node);
    }

    public void display(String indent) {
        System.out.println(indent + "📁 " + name);
        for (FileSystemNode child : children) {
            child.display(indent + "  ");
        }
    }
}
