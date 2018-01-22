package beans;

/**
 * Created by huangyusong on 18-1-22.
 */
public class BeanReference {
    private String name;

    private Object bean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public BeanReference(String name) {
        this.name = name;
    }

    public BeanReference(String name, Object bean) {
        this.name = name;
        this.bean = bean;
    }
}
