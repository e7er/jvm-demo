package com.e7er.thread.high.controller;

import com.e7er.thread.high.util.HttpRequestErrorUtil;
import com.e7er.thread.high.util.HttpRequestUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhantong
 * @version 1.0
 * @class RequestController
 * @description TODO
 * @date 2022-08-31
 */
@RestController
@Slf4j
public class RequestController {

    @GetMapping("/get")
    public String get() {
        Response response;
        try {
            return HttpRequestErrorUtil.get("http://www.baidu.com");
        } catch (Exception e) {
            log.error("网络请求错误", e);
            throw new RuntimeException("error");
        }
    }
}