package demo.holder;

import java.util.Map;

/**
 * @author allen
 * @date 2019/6/26 14:52
 **/
public class ParamsHolder {

    private static final ThreadLocal<Map<String, Object>> THREADLOCAL = new ThreadLocal<>();

    public static void set(Map<String, Object> params) {
        THREADLOCAL.set(params);
    }

    public static Map<String, Object> get() {
        return THREADLOCAL.get();
    }

    public static void remove() {
        THREADLOCAL.remove();
    }

}
