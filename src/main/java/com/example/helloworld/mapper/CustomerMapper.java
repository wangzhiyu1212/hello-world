package com.example.helloworld.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.helloworld.entity.Customer;

@Mapper
public interface CustomerMapper {
    int insert(Customer record);

    int insertSelective(Customer record);
    
    @Insert({"INSERT INTO customer (customer_id,name,sex,points) VALUES (#{customerId},#{name},'M',100)"})
    int insertCustomer(@Param("customerId")Long customerId, @Param("name")String name);
}