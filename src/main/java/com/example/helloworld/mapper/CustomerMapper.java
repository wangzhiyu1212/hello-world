package com.example.helloworld.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.helloworld.entity.Customer;

@Mapper
public interface CustomerMapper {
    int deleteByPrimaryKey(Long customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Long customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}