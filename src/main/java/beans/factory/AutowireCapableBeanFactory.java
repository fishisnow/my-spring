package beans.factory;

import beans.BeanDefinition;

/**
 * Created by huangyusong on 18-1-7.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object doGetBean(BeanDefinition beanDefinition) {
        try {
            return beanDefinition.getBeanClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
