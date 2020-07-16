package com.lyq.controller;

import com.alibaba.fastjson.JSON;
import com.lyq.command.utils.RedisUtil;
import com.lyq.entry.CityInfo;
import com.lyq.service.GeoService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/geo")
public class RedisGeoController {

    private  List<CityInfo> cityInfos;

    @Autowired
    private GeoService geoService;

    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private  StringRedisTemplate stringRedisTemplate;




    @RequestMapping("test1")
    public boolean test1(){
        stringRedisTemplate.opsForValue().set("a", "sadsa");
//        redisUtil.set("a", "123");
        Long aLong = geoService.saveCityInfoToRedis(cityInfos);
        System.out.println(aLong);
        return redisUtil.set("b", "123");
    }

    @RequestMapping("test2")
    public Long test2(){
        cityInfos = new ArrayList<>();

        cityInfos.add(new CityInfo("hefei", 117.17, 31.52));
        cityInfos.add(new CityInfo("anqing", 117.02, 30.31));
        cityInfos.add(new CityInfo("huaibei", 116.47, 33.57));
        cityInfos.add(new CityInfo("suzhou", 116.58, 33.38));
        cityInfos.add(new CityInfo("fuyang", 115.48, 32.54));
        cityInfos.add(new CityInfo("bengbu", 117.21, 32.56));
        cityInfos.add(new CityInfo("huangshan", 118.18, 29.43));
        cityInfos.add(new CityInfo("汕尾站", 115.435505,22.816308));
        cityInfos.add(new CityInfo("汕头站", 116.724787,23.435877));

        Long aLong = geoService.saveCityInfoToRedis(cityInfos);
        System.out.println(aLong);

        return geoService.saveCityInfoToRedis(cityInfos);
    }

    @RequestMapping("test3")
    public String test3(){
        List<Point> cityPos = geoService.getCityPos(
                Arrays.asList("anqing", "suzhou", "xxx").toArray(new String[3])
        );
        String s = JSON.toJSONString(geoService.getCityPos(
                Arrays.asList("anqing", "suzhou", "xxx").toArray(new String[3])
        ));
        System.out.println(s);
        return s;
    }
    @RequestMapping("test4")
    public List<Point> test4(){
        List<Point> cityPos = geoService.getCityPos(
                Arrays.asList("anqing", "suzhou", "xxx").toArray(new String[3])
        );

        return cityPos;
    }
    @RequestMapping("test5")
    public Point test5(String city){
        List<Point> cityPos1 = geoService.getCityPos(Arrays.asList(city).toArray(new String[1]));
        Point point = cityPos1.get(0);
        return point;
    }

    @RequestMapping("test6")
    public Distance test6(String city1,String city2){
        Distance twoCityDistance = geoService.getTwoCityDistance(city1, city2, Metrics.KILOMETERS);
        return twoCityDistance;
    }

    @RequestMapping("test7")
    public GeoResults test7(){
//        Circle within
        Point point = new Point(115.435505,22.816308);
        Circle circle = new Circle(point,149797);
        GeoResults<RedisGeoCommands.GeoLocation<String>> pointRadius = geoService.getPointRadius(circle, null);
        return pointRadius;
    }

    @RequestMapping("test8")
    public GeoResults test8(){
        Point point = new Point(115.435505,22.816308);
//        Circle circle = new Circle(point,149797);
        Circle circle = new Circle(point,3000000);
        RedisGeoCommands.GeoRadiusCommandArgs args =
                RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().limit(8).sortAscending();
        GeoResults<RedisGeoCommands.GeoLocation<String>> pointRadius = geoService.getPointRadius(circle, args);
        System.out.println(JSON.toJSONString(geoService.getPointRadius(circle, args)));
        return pointRadius;
    }

    @RequestMapping("test9")
    public GeoResults test9(){
        Distance radius = new Distance(200, Metrics.KILOMETERS);

        System.out.println(JSON.toJSONString(geoService.getMemberRadius("suzhou", radius, null)));

        // order by 距离 limit 2, 同时返回距离中心点的距离
        RedisGeoCommands.GeoRadiusCommandArgs args =
                RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().limit(2).sortAscending();
        System.out.println(JSON.toJSONString(geoService.getMemberRadius("suzhou", radius, args)));
        GeoResults<RedisGeoCommands.GeoLocation<String>> suzhou = geoService.getMemberRadius("suzhou", radius, args);
        return suzhou;
    }

    @RequestMapping("test10")
    public List test10(){
        System.out.println(JSON.toJSONString(geoService.getCityGeoHash(
                Arrays.asList("anqing", "suzhou", "xxx").toArray(new String[3])
        )));
        List<String> cityGeoHash = geoService.getCityGeoHash(
                Arrays.asList("anqing", "suzhou", "xxx").toArray(new String[3]));
        return cityGeoHash;
    }



}
