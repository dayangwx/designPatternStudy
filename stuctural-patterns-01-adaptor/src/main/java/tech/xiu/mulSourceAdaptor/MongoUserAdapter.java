package tech.xiu.mulSourceAdaptor;

/**
 * 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口。
 */
public class MongoUserAdapter implements UserDataProvider {
    private MongoClient client = new MongoClient();

    @Override
    public User fetchUser(String userId) {
        String name = client.findUser(userId);
        return new User(userId, name);
    }
}
