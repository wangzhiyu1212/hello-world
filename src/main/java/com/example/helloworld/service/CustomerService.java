package com.example.helloworld.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.helloworld.entity.Customer;
import com.example.helloworld.entity.Order;
import com.example.helloworld.mapper.CustomerMapper;
import com.example.helloworld.mapper.OrderMapper;

@Service
public class CustomerService {
	
	@Autowired
    private RedisTemplate 		redisTemplate;
	
	@Autowired
	private CustomerMapper 		customerMapper;
	
//	@Resource
//    private OrderMapper 		orderMapper;
	
	@RequestMapping("/")
	public String getName(Long id) {
//		for (int i = 0; i<100; i++) {
//			Order order = new Order();
//	        order.setOrderId(redisTemplate.opsForValue().increment("OrderId", 1L));
//	        order.setProductCode("redis");
//	        orderMapper.insert(order);
//		}
		
		for (int i = 0; i<100; i++) {
			customerMapper.insertCustomer(redisTemplate.opsForValue().increment("CustomerId", 1L), "redis");
		}

		return customerMapper.selectByPrimaryKey(id).getName();
				
	}
}
