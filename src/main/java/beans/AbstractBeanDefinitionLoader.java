package beans;

import beans.io.ResourceLoader;

import java.util.Map;

/**
 * Created by huangyusong on 18-1-12.
 * 从xml配置文件解析BeanDefinition
 */
public abstract class AbstractBeanDefinitionLoader implements BeanDefinitionLoader {

    private Map<String, BeanDefinition> registry; //注册到容器中的bean组成的map
    
    private ResourceLoader resourceLoader;
    

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
