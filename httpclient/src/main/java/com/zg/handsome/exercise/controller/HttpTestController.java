package com.zg.handsome.exercise.controller;

import com.zg.handsome.exercise.util.HttpsClientUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("httpClient")
public class HttpTestController {

    @GetMapping("baidu")
    public String baiduTest() {
        HttpsClientUtil httpClient = HttpsClientUtil.getHttpClient();
        Map<String, String> headMap = new HashMap<>();
        headMap.put("Content-Type" , "application/json");
        String s = httpClient.get("https://www.baidu.com", headMap, "utf-8");
        return s;
    }

    @RequestMapping("myScheduleTest")
    public String myScheduleTest(@RequestParam("timing") String timing) {
        HttpsClientUtil httpClient = HttpsClientUtil.getHttpClient();
        Map<String, String> headMap = new HashMap<>();
        headMap.put("Content-Type" , "application/json");

        Map<String, String> param = new HashMap<>();
        param.put("timing", timing);
        String s = httpClient.getMap("http://localhost:9980/MySchedule/startTask", headMap,param, "utf-8");
        return s;
    }
}
