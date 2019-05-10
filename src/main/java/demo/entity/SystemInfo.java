package demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * 自定义属性注入
 * 关键注解<code>@ConfigurationProperties</code>
 * 
 * 随后在配置类创建bean即可在其他需要的地方自动注入
 * @author zhaomengwei 
 */
@Getter
@Setter
@ConditionalOnMissingBean
@ConfigurationProperties("demo.sys")
public class SystemInfo {
    private String os;
    
    private String memory;
    
    @NestedConfigurationProperty
    private Preference preference;
}
