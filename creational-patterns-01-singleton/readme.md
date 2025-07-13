在 Java 等多线程环境中使用懒汉式单例设计模式时，线程安全是个非常重要的问题。懒汉式的特点是：在第一次使用时才创建实例，但如果多个线程同时调用获取实例的方法，可能会导致多个实例被创建——就破坏了单例的初衷。

下面是几种常见且有效的实现方式来确保懒汉式线程安全：

🧩 方法一：使用 synchronized（同步方法）
java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
✔ 优点：简单，容易理解。

❌ 缺点：每次调用都加锁，性能较低，哪怕已经创建完实例了也要同步。

🪄 方法二：双重检查锁（Double-Checked Locking）
java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) { // 第一次检查
            synchronized (Singleton.class) {
                if (instance == null) { // 第二次检查
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
✔ 优点：只在第一次创建对象时加锁，提高性能。

⚠ 注意：instance 必须声明为 volatile，防止指令重排序带来的线程安全问题。

📦 方法三：静态内部类（推荐）
java
public class Singleton {
    private Singleton() {}

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
✔ 优点：线程安全、懒加载、高性能。

利用了 JVM 类加载机制，Holder 类在第一次调用 getInstance() 时才加载，因此实例创建是线程安全的。

如果你正在写一个多线程项目，推荐使用第三种方式——静态内部类方式，它是最优雅且实用的懒汉式实现。

想看看哪种方式更适合你当前项目吗？可以告诉我你的使用场景，我可以帮你分析哪种更合适～🚀




Singleton.java
原理解析：JVM 类加载的延迟与线程安全
在 Java 中，类的加载过程是线程安全的。JVM 在加载类时会自动加锁，保证只有一个线程可以初始化该类。

当调用 getInstance() 方法时，Holder 类才会被加载，里面的 INSTANCE 对象也才会被创建。

由于这个加载过程由 JVM 保证线程安全，所以无论多少个线程同时访问 getInstance()，都会确保只创建一个实例。


## 面试问题
系统环境信息（System.getProperties()）？
Spring中怎么保持组件单例的？
ServletContext是什么（封装Servlet的信息）？是单例吗？怎么保证？
ApplicationContext是什么？是单例吗？怎么保证？
ApplicationContext： tomcat：一个应用（部署的一个war包）会有一个应用上下文
ApplicationContext： Spring：表示整个IOC容器（怎么保证单例的）。ioc容器中有很多组件（怎么保证单例）
数据库连接池一般怎么创建出来的，怎么保证单实例？
