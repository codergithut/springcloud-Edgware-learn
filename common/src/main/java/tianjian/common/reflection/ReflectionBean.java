package tianjian.common.reflection;

import tianjian.common.annotation.DefaultValue;
import tianjian.common.annotation.IgnoreValue;
import tianjian.common.annotation.NotNull;
import tianjian.exception.validate.NotNullException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 对bean进行反射验证处理
 */
public class ReflectionBean {
    public static <T> void checkObject(T t) throws NotNullException, IllegalAccessException {

        Class c = t.getClass();

        //获取字段上的注解值
        Field[] field = c.getDeclaredFields();
        if(field != null){
            for(Field fie : field){
                if(!fie.isAccessible()){
                    fie.setAccessible(true);
                }
                Object o = null;

                /**
                 * 如果该字段是有默认值选项
                 */
                DefaultValue defaultValue = fie.getAnnotation(DefaultValue.class);
                if(defaultValue != null) {
                    o = defaultValue;
                }

                /**
                 * 该字段需要忽律
                 */
                IgnoreValue ignoreValue = fie.getAnnotation(IgnoreValue.class);
                if(ignoreValue != null) {
                    o = ignoreValue;
                }

                /**
                 * 该字段不能为空
                 */
                NotNull notNull = fie.getAnnotation(NotNull.class);
                if(notNull != null) {
                    o = notNull;
                }

                if(o != null) {
                    detailField(o, fie, t);
                }
            }
        }
    }

    private static <T> void detailField(Object validate,Field field, T t) throws IllegalAccessException, NotNullException {
        if(validate instanceof DefaultValue) {
            DefaultValue defaultValue = (DefaultValue)validate;
                Method[] meth = defaultValue.annotationType().getDeclaredMethods();
                for(Method me : meth){
                    if(!me.isAccessible()){
                        me.setAccessible(true);
                    }
                    try {
                        //给字段重新赋值
                        Object o = field.get(t);
                        if(me.getName().equals("getDefaultValue") && field.get(t) == null) {
                            field.set(t, me.invoke(defaultValue, null));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
        }

        if(validate instanceof IgnoreValue) {
            field.set(t, null);
        }

        if(validate instanceof NotNull) {
            Object o = field.get(t);
            if(o == null) {
                throw new NotNullException("this", "error");
            }
        }
    }
}
