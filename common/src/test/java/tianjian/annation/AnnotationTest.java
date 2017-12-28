package tianjian.annation;

import org.junit.Test;
import tianjian.common.reflection.ReflectionBean;
import tianjian.bean.TestBean;
import tianjian.exception.validate.NotNullException;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * 自定义注解测试
 */
public class AnnotationTest {
    @Test
    public void TestAnnotation() throws IllegalAccessException, NotNullException {
        TestBean testBean = new TestBean();
        testBean.setName("test");
        testBean.setSex("nana");
        ReflectionBean.checkObject(testBean);
        assertEquals(testBean.getAge(), "10");
        assertEquals(testBean.getName(), "test");
        assertNull(testBean.getSex());
    }
}
