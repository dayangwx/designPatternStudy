package tech.xiu.mulSourceAdaptor;

/**
 * 适配者（Adaptee）类: REST API 模拟客户端
 */
public class RestApiClient {
    public String getUserFromApi(String userId) {
        return "Spike from REST API";
    }
}
