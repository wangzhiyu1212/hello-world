package com.example.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
    StringRedisTemplate stringRedisTemplate;
	
	@RequestMapping("/hello")
	public String getHello() {
        return "Hello World";
    }
	
	@RequestMapping("/redis")
	public String getRedis() {
		String source = stringRedisTemplate.opsForValue().get("mykey1");
		System.out.println("source:" + source);
        if (!StringUtils.isEmpty(source)) {
            return source;
        }
        
        return "Wrong";
	}
}
