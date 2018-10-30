package com.example;

import com.example.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baizongjie on 2017/5/2.
 */
@RestController
public class HelloController {
    @Autowired
    RedisService redisService;

    //访问/hello或者/hi任何一个地址，都会返回一样的结果
    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String say(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("name","xiaoming");
        redisService.set("hello",map);
        return "hi you!!!" + redisService.get("hello");
    }
}
