package tech.xiu.lazy;


/**
 * 在 Java 中，类的加载过程是线程安全的。JVM 在加载类时会自动加锁，保证只有一个线程可以初始化该类。
 *
 * 当调用 getInstance() 方法时，Holder 类才会被加载，里面的 INSTANCE 对象也才会被创建。
 *
 * 由于这个加载过程由 JVM 保证线程安全，所以无论多少个线程同时访问 getInstance()，都会确保只创建一个实例。
 */
public class Singleton {
    private Singleton() {}

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
