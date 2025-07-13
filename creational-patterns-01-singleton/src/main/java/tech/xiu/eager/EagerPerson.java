package tech.xiu.eager;

/**
 * Eager Singleton Pattern
 * This class demonstrates the eager initialization of a singleton instance.
 * The instance is created at the time of class loading.
 *
 * 类加载时就初始化实例
 * 多线程环境下安全
 * 实例创建早于真正使用
 */
public class EagerPerson {

    private String name;

    private EagerPerson(String name) {
        this.name = name;
    }

    public static final EagerPerson instance = new EagerPerson("Eager Singleton");

    public static EagerPerson getInstance() {
        return instance;
    }

}
