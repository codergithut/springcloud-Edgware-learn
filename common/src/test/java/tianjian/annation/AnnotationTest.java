package tianjian.annation;

import org.junit.Test;
import tianjian.bean.TestBean;
import tianjian.common.reflection.CacheClassAnnotationInfo;
import tianjian.common.reflection.ReflectionAction;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * 自定义注解测试
 */
public class AnnotationTest {

    @Test
    public void TestAnnotation() throws Exception {
        CacheClassAnnotationInfo cacheClassAnnotationInfo = new CacheClassAnnotationInfo();
        ReflectionAction reflectionAction = new ReflectionAction();
        TestBean testBean = new TestBean();
        testBean.setName("test");
        testBean.setSex("nana");
        reflectionAction.setCacheClassAnnotationInfo(cacheClassAnnotationInfo);
        reflectionAction.checkObject(testBean);
        assertEquals(testBean.getAge(), "10");
        assertEquals(testBean.getName(), "test");
        assertNull(testBean.getSex());
    }
}
