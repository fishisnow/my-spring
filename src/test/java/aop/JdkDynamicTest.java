package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by huangyusong on 18-2-4.
 */
public class JdkDynamicTest implements InvocationHandler {

    private Object targetObject;

    public JdkDynamicTest(Object targetObject) {
        this.targetObject = targetObject;
    }

    public void before() {
        System.out.println("before.........");
    }

    public void after() {
        System.out.println("after..........");
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces()
                , this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(targetObject, args);
        after();
        return result;
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorldImpl();
        JdkDynamicTest jdkDynamicTest = new JdkDynamicTest(helloWorld);
        HelloWorld helloWorldProxy = (HelloWorld) jdkDynamicTest.getProxy();
        helloWorldProxy.print();
    }
}
