package com.enn.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 相比java proxy的代理功能，Cglib的代理功能更加强大
 * java proxy只能代理interface，cglib还能代理普通类
 * Cglib
 *
 * @author hacker
 */
public class ProxyByCglib implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object proxyInterface(Class clazz, Object... args) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        synchronized (method) {
            //调用父类中的方法
            System.out.println("Before invoke super method,result:"+result );
            result = methodProxy.invokeSuper(o, objects);
            System.out.println("After invoke super method,result:"+result);
        }
        return result;
    }

    public static void main(String[] args) {
        ProxyByCglib proxyByCglib = new ProxyByCglib();
        CommonIncrement incrementImpl = (CommonIncrement) proxyByCglib.proxyInterface(CommonIncrement.class);
        incrementImpl.increment();
        System.out.println(incrementImpl.getCount());
    }
}

interface Greetable {
    void greet();
}

class SimpleHello implements Greetable {
    @Override
    public void greet() {
        System.out.println("Hello");
    }
}
