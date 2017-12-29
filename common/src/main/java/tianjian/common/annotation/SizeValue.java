package tianjian.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对字段长度进行控制
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface SizeValue {

    /**
     * @return 字段的最小长度
     */
    long setMin();

    /**
     * @return 字段最大长度
     */
    long setMax();

}
