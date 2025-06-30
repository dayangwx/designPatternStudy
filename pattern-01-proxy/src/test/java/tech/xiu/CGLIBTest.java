package tech.xiu;


import org.junit.Test;
import tech.xiu.cglibs.proxy.ServiceProxy;
import tech.xiu.cglibs.service.AccountServiceImpl2;

public class CGLIBTest {

    @Test
    public void testCGLIB() {
        // CGLIB代理测试
        AccountServiceImpl2 proxy = (AccountServiceImpl2)new ServiceProxy(new AccountServiceImpl2()).getProxy();
        proxy.selectAccount();

    }

}
