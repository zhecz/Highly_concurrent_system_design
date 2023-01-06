package com.nr.springboot.controller;

import com.nr.springboot.redis.RedisService;
import com.nr.springboot.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    RedisService redisService;


    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<Long> redisGet() {
        Long v1 = redisService.get("key1", Long.class);
        return Result.success(v1);

    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<String> redisSet() {
        boolean ret = redisService.set("key2", "hello");
        String str = redisService.get("key2", String.class);
        return Result.success(str);
    }

}
