package beans.factory;

/**
 * Created by huangyusong on 17-11-16.
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;
}
