package demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回信息枚举类
 * 
 * @author zhaomengwei 
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {
    // 成功
    SUCCESS(200,"成功"),
    // 失败
    FAIL(400,"失败"),
    // 服务器异常
    ERROR(500,"服务器异常");
    
    private int code;
    private String msg;
    
}
