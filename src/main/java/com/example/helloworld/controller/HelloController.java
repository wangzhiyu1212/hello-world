package com.example.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.mapper.CustomerMapper;
import com.example.helloworld.service.CustomerService;

@RestController
public class HelloController {
	
	@Autowired
    private RedisTemplate 		redisTemplate;
	
	@Autowired
	private CustomerService		customerService;
	
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
	
	@RequestMapping("/mybatis")
	public String getCustomer() {
        return customerService.getName(new Long(1));
    }
}
