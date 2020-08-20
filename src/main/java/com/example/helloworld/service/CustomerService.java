package com.example.helloworld.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.helloworld.mapper.CustomerMapper;

@Service
public class CustomerService {

	private final static Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private CustomerMapper customerMapper;

	Long cid = new Long(10000000);

	public String insertCustomer() {

		customerMapper.insertCustomer(cid, String.valueOf(cid++));

		return "success";

	}

}
