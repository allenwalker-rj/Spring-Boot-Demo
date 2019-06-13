package demo.annotation;

import java.lang.annotation.*;

/**
 * 检测是否登录
 *
 * @author allen
 * @date 2019/6/13 14:55
 **/
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginCheck {


    /**
     * 是否禁止黑名单用户访问
     * @return
     */
    boolean forbidBlackUser() default false;
}
