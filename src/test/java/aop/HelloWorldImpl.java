package aop;

/**
 * Created by huangyusong on 18-2-4.
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void print() {
        System.out.println("hello world!");
    }
}
