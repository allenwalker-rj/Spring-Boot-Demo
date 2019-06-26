package demo.web.interceptor;

import demo.annotation.LoginCheck;
import demo.holder.ParamsHolder;
import demo.service.GundamUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaomengwei
 */
@Slf4j
public class DemoInterceptor implements HandlerInterceptor {

    @Resource
    private GundamUserService gundamUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            LOGGER.warn("当前操作handler不是 HandlerMethod:{} . response:{}. ", handler.getClass().getName(), request.getQueryString());
            return true;
        }

        HandlerMethod method = (HandlerMethod) handler;
        LoginCheck annotation = method.getMethodAnnotation(LoginCheck.class);
        if (annotation != null) {
            LOGGER.info("登陆检测");
            Map<String, Object> params = new HashMap<>(2);
            params.put("token", "token");
            params.put("sin", "sin");
            ParamsHolder.set(params);
            if (annotation.forbidBlackUser()) {
                LOGGER.info("进入黑名单用户环节");
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        ParamsHolder.remove();
    }
}
