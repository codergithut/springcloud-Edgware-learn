package tianjian.common.reflection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tianjian.common.annotation.DefaultValue;
import tianjian.common.annotation.IgnoreValue;
import tianjian.common.annotation.NotNull;
import tianjian.common.annotation.SizeValue;
import tianjian.exception.validate.NotNullException;
import tianjian.exception.validate.ParamSizeException;

import java.util.List;

@Service
public class ReflectionAction {

    public CacheClassAnnotationInfo getCacheClassAnnotationInfo() {
        return cacheClassAnnotationInfo;
    }

    public void setCacheClassAnnotationInfo(CacheClassAnnotationInfo cacheClassAnnotationInfo) {
        this.cacheClassAnnotationInfo = cacheClassAnnotationInfo;
    }

    @Autowired
    CacheClassAnnotationInfo cacheClassAnnotationInfo;

    public void  checkObject(Object t) throws Exception {

        List<AnnotationInfo> annotationInfos = cacheClassAnnotationInfo.getAnnotationInfoByClass(t.getClass());

        for(AnnotationInfo ann : annotationInfos) {
            if(ann.getAnnotation() instanceof DefaultValue) {
                Object value = ann.getField().get(t);
                if(value == null) {
                    String defaultValue = ann.getAnnotationValues().get("defaultValue");
                    ann.getField().set(t, defaultValue);
                }
            }

            if(ann.getAnnotation() instanceof IgnoreValue) {
                ann.getField().set(t, null);
            }

            if(ann.getAnnotation() instanceof NotNull) {
                if(ann.getField().get(t) == null) {
                    throw new NotNullException("参数有误", "请查找");
                }
            }

            if(ann.getAnnotation() instanceof SizeValue) {
                try {
                    int min = Integer.valueOf(ann.getAnnotationValues().get("min"));
                    int max = Integer.valueOf(ann.getAnnotationValues().get("max"));
                    if(min > max) {
                        throw new ParamSizeException("test", max, min);
                    }
                } catch (Exception e) {
                    throw new Exception("this is error");
                }
            }
        }
    }
}
