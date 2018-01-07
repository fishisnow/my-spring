package beans;

/**
 * Created by huangyusong on 18-1-7.
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    Object getBean() {
        return this.bean;
    }
}
