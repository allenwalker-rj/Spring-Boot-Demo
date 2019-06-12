package demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回信息类
 * 
 * 调用：<code>throw new GlobalException(new ResponseException(10000, "无效数据"));</code>
 *
 * @author zhaomengwei
 */
@Getter
@AllArgsConstructor
public class ResponseException implements IResponseCode{
    private int code;
    private String msg;
}
