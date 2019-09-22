package  com.enn.proxy;

import com.enn.proxy.Incrementable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static java.lang.reflect.Proxy.newProxyInstance;

/**
 * @author hacker
 */
public class SynchronizedHandler implements InvocationHandler {
        private Incrementable delegate;

        public static Incrementable newProxy(Incrementable delegate) {
            Incrementable o = (Incrementable) newProxyInstance(
                    delegate.getClass().getClassLoader(),
                    delegate.getClass().getInterfaces(),
                    new SynchronizedHandler(delegate));
            return o;
        }

    public SynchronizedHandler(Incrementable delegate) {
            this.delegate = delegate;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            synchronized (delegate) {
                return method.invoke(delegate, args);
            }
        }
}
