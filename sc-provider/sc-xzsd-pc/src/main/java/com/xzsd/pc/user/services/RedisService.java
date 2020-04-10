package com.xzsd.pc.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.xzsd.pc.util.ResponceData;
import com.xzsd.pc.util.ResponceDataState;

/**
 * redis服务
 * zhc
 * 2020年3月30日11:14:33
 */
@Service
@Component
public class RedisService {

    private ResponceData responceData;

//    @Resource
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 增加redis数据
     * @param key
     * @param value
     * @param time
     * @return ResponceData
     */
    public ResponceData responceData(String key,String value,String time){
        if( Integer.parseInt(time) > 0){
            //存入有期限的
//            RedisUtil redisUtil = new RedisUtil()
//            redisUtil.set("AAA","bbbbbbbbb",100);
//            if(null == redisTemplate){
//                System.out.println("空的？b");
//            }
            redisTemplate.opsForValue().set(key,value,Integer.parseInt(time));
            responceData = new ResponceData(ResponceDataState.values()[0].getCode(),"success",null);
        }
        else{
            redisTemplate.opsForValue().set(key,value);
            responceData = new ResponceData(ResponceDataState.values()[3].getCode(),"none",null);
        }
        return responceData;

    }








}
