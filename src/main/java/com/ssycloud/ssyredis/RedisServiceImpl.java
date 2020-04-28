package com.ssycloud.ssyredis;

import com.ssycloud.ssyredis.pojo.User;
import com.ssycloud.ssyredis.util.RedisLock;
import com.ssycloud.ssyredis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName
 * @Description redis测试服务
 * @Date $ $
 **/
@Service
public class RedisServiceImpl implements  RedisService {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RedisLock redisLock;
    @Override
    public void checkRedisString(String key,String value) {
        User user=new User();
        user.setName(key);
        user.setAge(value.trim());
        user.setSex(value.trim());
        long time=1000l;
        redisUtil.set(key,user,time);
        boolean flag=redisUtil.hasKey(key);
        System.out.println("是否含有key："+key+":"+flag);
        System.out.println("测试redis"+key+","+value+","+time);
    }

    @Override
    public void checkRedisList(String key, String value) {
        User user=new User();
        user.setName(key);
        user.setAge(value.trim());
        user.setSex(value.trim());
        long time=1000l;
        redisUtil.lSet(key,user);
        System.out.println("测试redis"+key+","+value+","+time);
    }

    @Override
    public void getRedisList(String key, long index) {
        User user=(User)redisUtil.lGetIndex(key,index);
        System.out.println("测试redis"+key+","+user);
    }

    @Override
    public void checkRedisLock(String key, long timeMil) {
        List<Thread> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            Thread td=new Thread(){
                @Override
                public void run() {
                    String time =timeMil+ System.currentTimeMillis()+"";
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
                    boolean lockFlag=redisLock.lock(key,time);
                    try {
                        if(lockFlag){
                            System.out.println(sdf.format(new Date())+" 线程"+Thread.currentThread()+"获得锁=============");
                            Thread.sleep(10l);
                        }else {
                            System.out.println("线程"+Thread.currentThread()+"未获得锁");
                            return;
                        }
                    }catch ( Exception e) {
                        e.printStackTrace();
                        // ${todo}: handle exception
                    }finally {
                        if(lockFlag){
                            redisLock.unlock(key,time);
                            System.out.println(sdf.format(new Date())+" 线程"+Thread.currentThread()+"解锁成功=============");
                        }
                    }
                }
            };
            list.add(td);
        }

        for(Thread td:list){
            td.start();
        }
    }
}
