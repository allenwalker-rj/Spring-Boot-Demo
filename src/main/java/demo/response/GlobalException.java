package demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 全局异常
 * 
 * @author zhaomengwei 
 */
@Getter
@Setter
@AllArgsConstructor
public class GlobalException extends Exception {
    private IResponseCode responseCode;
}
