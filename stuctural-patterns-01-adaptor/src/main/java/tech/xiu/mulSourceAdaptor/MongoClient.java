package tech.xiu.mulSourceAdaptor;

/**
 * 适配者（Adaptee）类: MongoDB 模拟客户端
 */
public class MongoClient {
    public String findUser(String userId) {
        return "Jerry from MongoDB";
    }
}
