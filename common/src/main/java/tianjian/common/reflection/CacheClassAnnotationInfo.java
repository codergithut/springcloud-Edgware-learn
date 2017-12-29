package tianjian.common.reflection;

import org.springframework.stereotype.Service;
import tianjian.common.annotation.DefaultValue;
import tianjian.common.annotation.IgnoreValue;
import tianjian.common.annotation.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对注解信息和类进行关联,以便缓存处理
 */
@Service
public class CacheClassAnnotationInfo {

    Map<Class, List<AnnotationInfo>> cacheManager = new HashMap<Class, List<AnnotationInfo>>();

    public List<AnnotationInfo> getAnnotationInfoByClass(Class t) throws InvocationTargetException, IllegalAccessException {
        if (cacheManager.containsKey(t)) {
            return cacheManager.get(t);
        } else {
            List<AnnotationInfo> annotationInfos = new ArrayList<AnnotationInfo>();
            Field[] field = t.getDeclaredFields();
            if (field != null) {
                for (Field fie : field) {
                    if (!fie.isAccessible()) {
                        fie.setAccessible(true);
                    }
                    Object o = null;

                    /**
                     * 如果该字段是有默认值选项
                     */
                    DefaultValue defaultValue = fie.getAnnotation(DefaultValue.class);
                    if (defaultValue != null) {
                        o = defaultValue;
                    }

                    /**
                     * 该字段需要忽律
                     */
                    IgnoreValue ignoreValue = fie.getAnnotation(IgnoreValue.class);
                    if (ignoreValue != null) {
                        o = ignoreValue;
                    }

                    /**
                     * 该字段不能为空
                     */
                    NotNull notNull = fie.getAnnotation(NotNull.class);
                    if (notNull != null) {
                        o = notNull;
                    }

                    if (o != null) {
                        AnnotationInfo annotationInfo = new AnnotationInfo();
                        annotationInfo.setField(fie);
                        annotationInfo.setAnnotation(o);
                        annotationInfo.analysAnnotation();
                        annotationInfos.add(annotationInfo);
                    }
                }
            }
            cacheManager.put(t, annotationInfos);
            return annotationInfos;
        }
    }


}
