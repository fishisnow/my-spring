package beans;

/**
 * Created by huangyusong on 18-1-7.
 * Bean的注册接口，用来向注册表中注册BeanDefinition的实例
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册接口方法
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception;

    void removeBeanDefinition(String beanName) throws Exception;
}
