package com.ssycloud.ssyredis;

public interface RedisService {
    //测试redis-String类型的k-v形式存储
    void checkRedisString(String key,String value);

    //测试redis-list类型的k-v形式存储
    void checkRedisList(String key,String value);

    //测试redis-list类型的k-v形式存储
    void getRedisList(String key,long index);

    void checkRedisLock(String key,long timeMil);
}
