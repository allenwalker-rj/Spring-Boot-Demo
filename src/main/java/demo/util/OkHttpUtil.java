package demo.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author allen
 * @date 2019/6/20 15:33
 **/
@Slf4j
public class OkHttpUtil {

    private volatile static OkHttpUtil okHttpUtil = null;

    private static final MediaType MEDIA_TYPE = MediaType.parse("text/x-markdown; charset=utf-8");

    public static OkHttpUtil getInstance() {
        if (okHttpUtil == null) {
            synchronized (OkHttpUtil.class) {
                if (okHttpUtil == null) {
                    okHttpUtil = new OkHttpUtil();
                }
            }
        }
        return okHttpUtil;
    }

    /**
     * 同步GET请求
     *
     * @param url     请求地址
     * @param headers 请求头信息
     * @return boolean
     */
    public static boolean doGet(String url, Headers headers) {
        Request.Builder builder = new Request.Builder().url(url);
        if (headers != null) {
            builder.headers(headers);
        }
        Request request = builder.build();
        OkHttpClient okHttpClient = HttpHelper.getInstance().getOkHttpClient();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.body() != null) {
                LOGGER.info("okHttpClient doGet response:`{}`", response.body().string());
            }
            if (response.isSuccessful()) {
                return true;
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }

    /**
     * 同步POST请求
     *
     * @param url     请求地址
     * @param headers 请求头参数
     * @param params  请求参数
     * @return boolean
     */
    public static boolean doPost(String url, Headers headers, String params) {
        Request.Builder builder = new Request.Builder();
        if (headers != null) {
            builder.headers(headers);
        }
        Request request = builder.url(url)
                .post(RequestBody.create(MEDIA_TYPE, params))
                .build();
        OkHttpClient okHttpClient = HttpHelper.getInstance().getOkHttpClient();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.body() != null) {
                LOGGER.info("okHttpClient doPost response:`{}`", response.body().string());
            }
            if (response.isSuccessful()) {
                return true;
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }


    private static class HttpHelper {
        private static int DEFAULT_TIMEOUT = 5;
        private OkHttpClient okHttpClient;

        private HttpHelper() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            okHttpClient = builder.build();
        }

        private static HttpHelper getInstance() {
            return HttpHelperHolder.instance;
        }

        private OkHttpClient getOkHttpClient() {
            return okHttpClient;
        }

        private static class HttpHelperHolder {
            private static HttpHelper instance = new HttpHelper();
        }
    }
}
