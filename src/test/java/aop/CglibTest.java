package aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by huangyusong on 18-2-4.
 */
public class CglibTest implements MethodInterceptor {

    private Object targetObject;

    public CglibTest(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetObject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public void before() {
        System.out.println("before.........");
    }

    public void after() {
        System.out.println("after..........");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(method.getName());
        after();
        return result;
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorldImpl();
        CglibTest cglibTest = new CglibTest(helloWorld);
        HelloWorld helloWorldProxy = (HelloWorld) cglibTest.getProxy();
        helloWorldProxy.hashCode();
        helloWorldProxy.getClass();
    }
}
