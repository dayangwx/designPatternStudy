package tech.xiu.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceProxy implements InvocationHandler {

    // Real Subject
    private Object realSubject;

    public Object getTarget(Object obj) {
        this.realSubject = obj;
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),  // 传入被代理对象的类加载器
                obj.getClass().getInterfaces(),  // 传入被代理对象的接口,数组,如果是多个接口,那就传入多个接口,这个代理会拥有多个接口的所有方法
                this);// InvocationHandler 实现类, 那就是当前类, ServiceProxy
    }

    public void prepare() {
        System.out.println("准备工作...");
    }

    public void after() {
        System.out.println("善后工作...");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("Proxy class: " + proxy.getClass().getName());
        prepare();
        Object result = method.invoke(realSubject, args);
        after();
        return result;
    }
}
