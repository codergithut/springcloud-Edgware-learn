package tianjian.common;

/**
 * 数据类型,默认是String 可以通过反射获取返回值类型,但是呢太麻烦了先加个这个东西取巧 后面有时间去除此注解
 */
public enum Type {

    INTEGER("int"), STRING("string");

    private String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
