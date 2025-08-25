package tech.xiu.mulSourceAdaptor;

/**
 * 适配者（Adaptee）类: MySQL 模拟客户端
 */
public class MySQLClient {
    public String queryUser(String userId) {
        return "Tom from MySQL";
    }
}
