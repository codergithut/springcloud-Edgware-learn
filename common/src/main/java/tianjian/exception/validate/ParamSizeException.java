package tianjian.exception.validate;

public class ParamSizeException extends Exception{
    public ParamSizeException(String paramName, int max, int min) {
        super(paramName + ": max = " + max + " min = " + min);
    }
}
