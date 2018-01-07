package beans.factory;

import beans.BeanDefinition;
import beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * Created by huangyusong on 18-1-7.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object doGetBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            applyPropertyValues(bean, beanDefinition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws NoSuchFieldException, IllegalAccessException {
        for(PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
        }
    }
}
