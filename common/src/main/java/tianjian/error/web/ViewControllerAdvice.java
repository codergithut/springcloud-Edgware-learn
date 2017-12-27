package tianjian.error.web;

import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tianjian.domain.error.CustomErrorType;
import tianjian.exception.web.view.ViewHandlerException;
import tianjian.web.ViewController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ControllerAdvice(basePackageClasses = ViewController.class)
public class ViewControllerAdvice implements ErrorViewResolver {

    @ExceptionHandler(ViewHandlerException.class)
    @ResponseBody
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest httpServletRequest, HttpStatus httpStatus, Map<String, Object> map) {

        return new ModelAndView("/error");
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }


}

