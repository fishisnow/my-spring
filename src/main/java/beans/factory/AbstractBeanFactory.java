package beans.factory;

import beans.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by huangyusong on 18-1-7.
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    @Override
    public Object getBean(String name) throws Exception {
        return beanDefinitionMap.get(name).getBean();
    }

    protected abstract Object doGetBean(BeanDefinition beanDefinition);


}
