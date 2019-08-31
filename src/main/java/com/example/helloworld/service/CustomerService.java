package com.example.helloworld.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.helloworld.entity.Customer;
import com.example.helloworld.entity.Order;
import com.example.helloworld.mapper.CustomerMapper;
import com.example.helloworld.mapper.OrderMapper;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerMapper 		customerMapper;
	
	@Resource
    private OrderMapper 		orderMapper;
	
	@RequestMapping("/")
	public String getName(Long id) {
		Order order = new Order();
        order.setOrderId(1);
        order.setProductCode("INSERT");
        orderMapper.insert(order);
        
        Customer customer = new Customer();
        customer.setCustomerId(new Long(2));
        customer.setName("test2");
        customerMapper.insert(customer);
        
		return customerMapper.selectByPrimaryKey(id).getName();
				
	}
}
