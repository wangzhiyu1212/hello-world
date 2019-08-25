package com.example.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloworld.mapper.CustomerMapper;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerMapper 		customerMapper;
	
	public String getName(Integer id) {
		return customerMapper.selectByPrimaryKey(id).getName();
	}
}
