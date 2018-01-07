package beans.factory;

import beans.BeanDefinition;
import beans.BeanDefinitionRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by huangyusong on 18-1-7.
 */
public abstract class AbstractBeanFactory implements BeanFactory, BeanDefinitionRegistry {
    Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    @Override
    public Object getBean(String name) throws Exception {
        return beanDefinitionMap.get(name).getBean();
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception {
        Object bean = doGetBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public void removeBeanDefinition(String beanName) throws Exception {
        beanDefinitionMap.remove(beanName);
    }

    protected abstract Object doGetBean(BeanDefinition beanDefinition);


}
