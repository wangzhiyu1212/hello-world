package com.example.helloworld.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.helloworld.entity.Customer;

@Mapper
public interface CustomerMapper {
    int deleteByPrimaryKey(Long customerId);

    int insert(Customer record);
    
    int insertCustomer(@Param("customerId")Long customerId, @Param("name")String name);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Long customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    int updateByCustomerId(@Param("customerId")Long customerId);
}