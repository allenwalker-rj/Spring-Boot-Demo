package demo.response;

import lombok.Getter;

/**
 * web返回实体
 * @param <T>
 * 
 * @author zhaomengwei 
 */
@Getter
public class ResponseEntity<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResponseEntity<T> setResponseCode(ResponseCode responseCode){
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        return this;
    }

    public ResponseEntity<T> setCode(Integer code){
        this.code = code;
        return this;
    }

    public ResponseEntity<T> setMsg(String msg){
        this.msg = msg;
        return this;
    }

    public ResponseEntity<T> setData(T data){
        this.data = data;
        return this;
    }
}
