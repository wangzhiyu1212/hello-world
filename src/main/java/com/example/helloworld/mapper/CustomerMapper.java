package com.example.helloworld.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.helloworld.entity.Customer;

@Mapper
public interface CustomerMapper {
    int deleteByPrimaryKey(Long customerId);

    int insert(Customer record);
    
    @Insert({"INSERT INTO customer (customer_id,name,sex,poinsts) VALUES (#{customerId},#{name},'M',100)"})
    int insertCustomer(@Param("customerId")Long customerId, @Param("name")String name);

    @Select("select name from customer where customer_id = #{customerId}")
    List<String> selectByQuestion(Long customerId);
    
    Customer selectByPrimaryKey(Long customerId);
   
    int updateByCustomerId(@Param("customerId")Long customerId);
}