package com.e7er.thread.high.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author zhantong
 * @version 1.0
 * @class HttpRequestUtil
 * @description http工具类
 * @date 2022-08-31
 */
@Slf4j
public class HttpRequestUtil {
    static OkHttpClient client = new OkHttpClient().newBuilder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectionPool(new ConnectionPool(5, 30, TimeUnit.SECONDS))
            .build();

    public static String get(String url) {
        Request request = new Request.Builder().url(url)
                .build();
        String result = "";
        try {
            Response response = client.newCall(request).execute();
            result = Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            log.error("网络请求错误", e);
        }
        return result;
    }
}