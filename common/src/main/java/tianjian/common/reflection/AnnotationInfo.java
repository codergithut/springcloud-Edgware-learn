package tianjian.common.reflection;

import tianjian.common.annotation.DefaultValue;
import tianjian.common.annotation.IgnoreValue;
import tianjian.common.annotation.NotNull;
import tianjian.common.annotation.SizeValue;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnnotationInfo {

    /**
     * 注解实例
     */
    private Object annotation;

    /**
     * 注解对应的反射字段
     */
    private Field field;

    /**
     * 注解包含的值 目前@DefaultValue @SizeValue 注解会存在特定值的情况
     */
    private Map<String,String> annotationValues;

    public Object getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Object annotation) {
        this.annotation = annotation;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Map<String, String> getAnnotationValues() {
        return annotationValues;
    }

    /**
     *
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * 对某个方法的注解进行分析用于获取注解对应的值
     */
    public void analysAnnotation() throws InvocationTargetException, IllegalAccessException {

        if(annotation instanceof DefaultValue) {
            DefaultValue defaultValue = (DefaultValue) annotation;
            Method[] meth = defaultValue.annotationType().getDeclaredMethods();
            annotationValues = getDatas(meth, defaultValue);
        }

        if(annotation instanceof SizeValue) {
            SizeValue sizeValue = (SizeValue) annotation;
            Method[] meth = sizeValue.annotationType().getDeclaredMethods();
            annotationValues = getDatas(meth, sizeValue);
        }


    }

    private Map<String,String> getDatas(Method[] meth, Object o) throws InvocationTargetException, IllegalAccessException {
        Map<String,String> data = new HashMap<String,String>();
        for (Method me : meth) {
            if (!me.isAccessible()) {
                me.setAccessible(true);
            }
            if (me.getName().equals("getDefaultValue") && o instanceof DefaultValue) {
                /**
                 *  不严谨,但是对于bean来说应该够了 如果出现bug优先查看此方法是不是跑题了
                 */
                String value = me.invoke(o, null).toString();
                data.put("defaultValue", value);
            }
            if ( o instanceof SizeValue) {
                if(me.getName().equals("setMin")) {
                    String value = me.invoke(o, null).toString();
                    data.put("min", value);
                }

                if(me.getName().equals("setMax")) {
                    String value = me.invoke(o, null).toString();
                    data.put("max", value);
                }
            }
        }
        return data;
    }

}
