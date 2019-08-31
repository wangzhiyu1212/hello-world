package com.example.helloworld.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.helloworld.entity.Order;

@Mapper
public interface OrderMapper {

	Long insert(Order model);
	
}
