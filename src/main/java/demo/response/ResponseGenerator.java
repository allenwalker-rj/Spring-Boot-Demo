package demo.response;

/**
 * 统一返回结果生成类
 * 
 * @author zhaomengwei 
 */
public class ResponseGenerator {
    
    public static <T> ResponseEntity<T> success(){
        return new ResponseEntity<T>().setResponseCode(ResponseCode.SUCCESS);
    }

    public static <T> ResponseEntity<T> success(T data){
        return new ResponseEntity<T>().setResponseCode(ResponseCode.SUCCESS).setData(data);
    }

    public static <T> ResponseEntity<T> error(){
        return new ResponseEntity<T>().setResponseCode(ResponseCode.FAIL);
    }

    public static <T> ResponseEntity<T> internalError(){
        return new ResponseEntity<T>().setResponseCode(ResponseCode.ERROR);
    }

    public static <T> ResponseEntity<T> generate(Integer code, String msg, T data){
        return new ResponseEntity<T>().setCode(code).setMsg(msg).setData(data);
    }

    public static <T> ResponseEntity<T> error(ResponseCode responseCode){
        return new ResponseEntity<T>().setResponseCode(responseCode);
    }
}
