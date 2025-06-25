package tech.xiu;


import tech.xiu.statics.proxy.AccountServiceProxy;
import tech.xiu.statics.service.AccountService;
import tech.xiu.statics.service.AccountServiceImpl;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        // 1. 创建一个AccountServiceImpl对象
         AccountService accountService = new AccountServiceImpl();
        // 2. 创建一个AccountServiceProxy对象
         AccountServiceProxy accountServiceProxy = new AccountServiceProxy(accountService);
        // 3. 调用AccountServiceProxy的addAccount方法
         accountServiceProxy.addAccount();
        // 4. 调用AccountServiceProxy的selectAccount方法
        System.out.println("------------------");
         accountServiceProxy.selectAccount();
    }
}
