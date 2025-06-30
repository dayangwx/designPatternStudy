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
        // AccountService是一个接口，AccountServiceImpl是它的实现类，AccountServiceProxy是AccountService的代理类
        // 1. 创建一个AccountServiceImpl对象, 他就是真实主体RealSubject
         AccountService accountService = new AccountServiceImpl();
        // 2. 创建一个AccountServiceProxy对象，他就是代理Proxy，用来代理真实主体的. Proxy对象通常会持有一个真实主体的引用
         AccountServiceProxy accountServiceProxy = new AccountServiceProxy(accountService);
        // 3. 调用AccountServiceProxy的addAccount方法
         accountServiceProxy.addAccount();
        // 4. 调用AccountServiceProxy的selectAccount方法
        System.out.println("------------------");
         accountServiceProxy.selectAccount();
    }
}
