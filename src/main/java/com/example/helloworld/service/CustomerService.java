package com.example.helloworld.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.helloworld.mapper.CustomerMapper;

@Service
public class CustomerService {

	private final static Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private CustomerMapper customerMapper;
	
	Long cid = new Long(10000003);

	public String insertCustomer() {
		// for (int i = 0; i<100; i++) {
		// Order order = new Order();
		// order.setOrderId(redisTemplate.opsForValue().increment("OrderId", 1L));
		// order.setProductCode("redis");
		// orderMapper.insert(order);
		// }

		// for (int i = 0; i<100; i++) {
		// customerMapper.insertCustomer(redisTemplate.opsForValue().increment("CustomerId",
		// 1L), "redis");
		// logger.info("i:" + i);
		// }

		//		return customerMapper.selectByPrimaryKey(id).getName();
		customerMapper.insertCustomer(cid, String.valueOf(cid++));
		
		return "success";

	}
	
}
