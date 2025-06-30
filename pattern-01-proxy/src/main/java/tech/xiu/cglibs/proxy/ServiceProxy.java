package tech.xiu.cglibs.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib的优点在于它可以不依赖接口来实现动态代理.
 * 底层是给被代理对象创建了子类
 *
 * 步骤:
 *  1: new Enhancer
 *  2: 设置父类
 *  3: interceptor方法, 拦截所有方法.
 *  4: create()
 */
public class ServiceProxy {

    private Object target;

    public ServiceProxy(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        // 1. 创建Enhancer对象
        Enhancer enhancer = new Enhancer();

        // 2. 设置父类 为什么要设置父类? 因为cglib代理方式不需要interface, 它在底层是创建了被代理对象的子类,这样子,代理对象就拥有了被代理对象所有的方法.
        enhancer.setSuperclass(target.getClass());

        // 3. 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib 来帮你做前置工作了.."+method.getName());
                Object result = methodProxy.invokeSuper(o, args);
                System.out.println("cglib 来帮你善后了..."+method.getName());
                return result;
            }
        });

        // 4. 创建代理对象
        Object o = enhancer.create();
        return o;
    }
}
