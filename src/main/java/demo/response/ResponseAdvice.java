package demo.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

/**
 * controller 返回结果处理
 * 包装{"code":"","msg":"","data":object}
 * 
 * @author zhaomengwei 
 */
@RestControllerAdvice
public class ResponseAdvice extends JsonViewResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        if (MappingJackson2HttpMessageConverter.class.getName().equals(converterType.getName())) {
            return true;
        }
        return super.supports(returnType, converterType);
    }

    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType,
            MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {
        bodyContainer.setValue(ResponseGenerator.success(bodyContainer.getValue()));
    }
    
}
