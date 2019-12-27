package com.example.helloworld.mapper;

import com.example.helloworld.entity.Customer;

public interface CustomerMapper {
    int insert(Customer record);

    int insertSelective(Customer record);
}