package com.example.helloworld.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.example.helloworld.entity.Customer;

public interface CustomerMapper {
    int insert(Customer record);

    int insertSelective(Customer record);
    
    @Insert({"INSERT INTO customer (customer_id,name,sex,poinsts) VALUES (#{customerId},#{name},'M',100)"})
    int insertCustomer(@Param("customerId")Long customerId, @Param("name")String name);
    
}