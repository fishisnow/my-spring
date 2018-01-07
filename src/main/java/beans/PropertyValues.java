package beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangyusong on 18-1-8.
 * 自动注入bean的属性，这里用bean封装而没有使用List
 */
public class PropertyValues {

    private List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValues.add(propertyValue);
    }


    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }
}
