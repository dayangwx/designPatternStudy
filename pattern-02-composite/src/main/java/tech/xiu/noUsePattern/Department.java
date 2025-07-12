package tech.xiu.noUsePattern;

import java.util.ArrayList;
import java.util.List;

class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("部门：" + name);
    }
}

class OrgGroup {
    private String name;
    private List<Object> children = new ArrayList<>(); // 不统一类型！

    public OrgGroup(String name) {
        this.name = name;
    }

    public void add(Object child) {
        children.add(child);
    }

    public void print() {
        System.out.println("单位：" + name);
        for (Object child : children) {
            if (child instanceof Department) {
                ((Department) child).print();
            } else if (child instanceof OrgGroup) {
                ((OrgGroup) child).print();
            }
        }
    }
}
