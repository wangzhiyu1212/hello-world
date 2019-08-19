package com.example.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
    RedisTemplate 		redisTemplate;
	
	@RequestMapping("/")
	public String getHello() {
        return "Hello World";
    }
	
	@RequestMapping("/redis")
	public String getRedis() {

		try {
            return String.valueOf(redisTemplate.opsForValue().increment("SSOsessionId", 1L));
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return "empty";
	}
}
