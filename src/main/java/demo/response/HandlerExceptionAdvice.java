package demo.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * controller异常处理
 * 
 * @author zhaomengwei 
 */
@RestControllerAdvice(annotations = Controller.class)
public class HandlerExceptionAdvice {
    
    @ExceptionHandler(value = GlobalException.class)
    public Object globalExceptionHandler(HttpServletRequest request, GlobalException ex){
        return ResponseGenerator.error(ex.getResponseCode());
    }

    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(HttpServletRequest request, Exception ex){
        return ResponseGenerator.error();
    }
}
