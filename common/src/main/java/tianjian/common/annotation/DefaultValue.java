package tianjian.common.annotation;

import tianjian.common.Type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 设置默认注解 如果值为null 就设置为我们定义的值
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface DefaultValue {
    String getDefaultValue();
    Type getType();
}
