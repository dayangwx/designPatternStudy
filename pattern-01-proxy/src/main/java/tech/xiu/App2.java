package tech.xiu;


import tech.xiu.dynamic.proxy.ServiceProxy;
import tech.xiu.dynamic.service.AccountService;
import tech.xiu.dynamic.service.AccountServiceImpl;

/**
 * Hello world!
 *
 */
public class App2
{
    public static void main( String[] args )
    {
        // 2. 创建一个AccountServiceProxy对象，他就是代理Proxy，用来代理真实主体的. Proxy对象通常会持有一个真实主体的引用
        // 1. 创建一个AccountServiceImpl对象，他就是主体Subject
        AccountService accountService = (AccountService)new ServiceProxy().getTarget(new AccountServiceImpl());
        // 3. 调用AccountServiceProxy的addAccount方法
        System.out.println("------------------");
        accountService.addAccount();
        // 4. 调用AccountServiceProxy的selectAccount方法
        System.out.println("------------------");
        accountService.selectAccount();
    }
}
