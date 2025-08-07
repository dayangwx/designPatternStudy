package tech.xiu.mulSourceAdaptor;

// 目标（Target）接口
public interface UserDataProvider {
    User fetchUser(String userId);
}
