package tech.xiu;

import java.util.ArrayList;
import java.util.List;

// 统一接口
interface OrgNode {
    void print();
}

// 叶子节点：部门
class Department implements OrgNode {
    private String name;
    Department(String name) { this.name = name; }
    public void print() { System.out.println("部门：" + name); }
}

// 容器节点：公司或上级单位
class OrgGroup implements OrgNode {
    private String name;
    private List<OrgNode> children = new ArrayList<>();

    OrgGroup(String name) {
        this.name = name;
    }

    public void add(OrgNode node) {
        children.add(node);
    }

    public void print() {
        System.out.println("单位：" + name);
        for (OrgNode node : children) {
            node.print(); // 不需要判断 node 是不是部门，直接用！
        }
    }
}
