package tianjian.bean;

import tianjian.common.Type;
import tianjian.common.annotation.DefaultValue;
import tianjian.common.annotation.IgnoreValue;
import tianjian.common.annotation.NotNull;

/**
 * 测试bean
 */
public class TestBean {

    @NotNull
    public String name;

    @DefaultValue(getDefaultValue = "10", getType = Type.STRING)
    public String age;

    @IgnoreValue
    public String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
