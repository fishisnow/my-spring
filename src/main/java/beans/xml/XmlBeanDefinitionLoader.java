package beans.xml;

import beans.AbstractBeanDefinitionLoader;
import beans.BeanDefinition;
import beans.BeanReference;
import beans.PropertyValue;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Created by huangyusong on 18-1-12.
 */
public class XmlBeanDefinitionLoader extends AbstractBeanDefinitionLoader {
    @Override
    public void loadBeanDefinition(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinition(inputStream);
    }

    private void doLoadBeanDefinition(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputStream);
        //从xml文件中解析bean
        registerBeanDefinition(doc);
        inputStream.close();
    }

    private void registerBeanDefinition(Document doc) {
        Element root = doc.getDocumentElement(); //根节点
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) {
        //遍历其子节点
        NodeList nodeList = root.getChildNodes();
        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    processBeanDefinition((Element) node);
                }
            }
        }
    }

    private void processBeanDefinition(Element element) {
        // xml中声明的bean节点
        String name = element.getAttribute("id");
        String className = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processBeanProperty(element, beanDefinition);
        beanDefinition.setBeanClassName(className);

        //将这个bean注册到容器中
        getRegistry().put(name, beanDefinition);
    }

    //解析bean的属性值
    private void processBeanProperty(Element element, BeanDefinition beanDefinition) {
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String propertyName = propertyEle.getAttribute("name");
                String propertyValue = propertyEle.getAttribute("value");
                if (StringUtils.isNotBlank(propertyValue)) {
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(propertyName, propertyValue));
                } else {
                    String ref = propertyEle.getAttribute("ref");
                    if (StringUtils.isBlank(propertyValue)) {
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + propertyName + "' must specify a ref or value");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(propertyName, beanReference));
                }
            }
        }
    }
}
