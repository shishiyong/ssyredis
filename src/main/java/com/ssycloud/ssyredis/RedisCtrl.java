package com.ssycloud.ssyredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName
 * @Description //TODO $
 * @Date $ $
 **/
@RestController
public class RedisCtrl {
    @Autowired
    private RedisService redisService;


    /**
     * @Author shishiyong
     * @Description //TODO
     * @Date 23:12 2019/6/22
     * @Param [name, orderNo]
     * @return java.lang.String
     **/
    @GetMapping("/checkRedisString/{keyStr}/{value}")
    public String checkRedisString(@PathVariable("keyStr") String key, @PathVariable("value") String value) {
        redisService.checkRedisString(key,value);
        return key+value;

    }

    /**
     * @Author shishiyong
     * @Description
     * @Date 23:12 2019/6/22
     * @Param [name, orderNo]
     * @return java.lang.String
     **/
    @GetMapping("/checkRedisList/{keyStr}/{value}")
    public String checkRedisList(@PathVariable("keyStr") String key, @PathVariable("value") String value) {
        redisService.checkRedisList(key,value);
        return key+value;

    }

    /**
     * @Author shishiyong
     * @Description
     * @Date 23:12 2019/6/22
     * @Param [name, orderNo]
     * @return java.lang.String
     **/
    @GetMapping("/getRedisList/{keyStr}/{index}")
    public String getRedisList(@PathVariable("keyStr") String key, @PathVariable("index") long index) {
        redisService.getRedisList(key,index);
        return key+index;

    }

    /**
     * @Author shishiyong
     * @Description
     * @Date 23:12 2019/6/22
     * @Param [name, orderNo]
     * @return java.lang.String
     **/
    @GetMapping("/checkRedisLock/{keyStr}/{timemil}")
    public String checkRedisLock(@PathVariable("keyStr") String key, @PathVariable("timemil") long timemil) {
        redisService.checkRedisLock(key,timemil);
        return key+timemil;

    }
}
