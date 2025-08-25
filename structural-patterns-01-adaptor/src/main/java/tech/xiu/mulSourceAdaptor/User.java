package tech.xiu.mulSourceAdaptor;

// 用户模型类
public class User {
    private String userId;
    private String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String toString() {
        return "User{id='" + userId + "', name='" + name + "'}";
    }
}
