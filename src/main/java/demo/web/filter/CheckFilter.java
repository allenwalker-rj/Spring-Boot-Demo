package demo.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 注解方式添加filter
 *
 * 启动类需加注解<code>@ServletComponentScan</code>
 * {@link org.springframework.boot.web.servlet.ServletComponentScan}
 * (不过只在内置容器中生效)
 *
 * spring的注解{@link import org.springframework.core.annotation.Order}
 * 并不会影响顺序，实际上此类在普通的web项目中也生效，servlet容器会自动注入此过滤器
 *
 * @author zhaomengwei
 * @since Servlet 3.0
 */
@Slf4j
@WebFilter(filterName = "checkFilter", urlPatterns = "/*")
public class CheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("注解实现的过滤器");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
