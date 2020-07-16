package com.lyq.service.impl;

import com.lyq.entry.CityInfo;
import com.lyq.service.BigmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BigmapServiceImpl implements BigmapService {
    private final String  Big_KEY = "ah-cities";

    /** redis 客户端 */
    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    public Long saveToRedis(Collection<CityInfo> cityInfos) {



//        redisTemplate.opsForCluster()
//        redisTemplate.opsForValue().setBit();

        return null;
    }
}
