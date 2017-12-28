package tianjian.exception.validate;

public class NotNullException extends Exception{
    public NotNullException(String param, String beanName) {
        super("check " + beanName + " param is null, but exception is not null");
    }
}
