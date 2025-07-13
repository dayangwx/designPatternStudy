package tech.xiu.lazy;

public class LazyPerson {

    private String name;

    private static LazyPerson instance;

    private LazyPerson(String name) {
        this.name = name;
    }

    public static synchronized LazyPerson getInstance(String name) {
        if (instance == null) {
            instance = new LazyPerson(name);
        }
        return instance;
    }
}
