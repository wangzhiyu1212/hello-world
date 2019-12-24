package com.example.helloworld.mapper;

import com.example.helloworld.entity.ProductOrder;

public interface ProductOrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(ProductOrder record);

    int insertSelective(ProductOrder record);

    ProductOrder selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(ProductOrder record);

    int updateByPrimaryKey(ProductOrder record);
}