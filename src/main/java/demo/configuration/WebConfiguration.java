package demo.configuration;

import demo.web.filter.DemoFilter;
import demo.web.interceptor.DemoInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * web层配置
 * @author zhaomengwei
 */
@Configuration("webConfiguration")
public class WebConfiguration extends WebMvcConfigurerAdapter {

    /**
     * 一种过滤器的实现方式
     * 另一种见{@link demo.web.filter.CheckFilter}
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DemoFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramNmae", "paramValue");
        registration.setName("demoFilter");
        registration.setOrder(2);

        return registration;

    }

    /**
     * 拦截器实现
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor());
    }
}
