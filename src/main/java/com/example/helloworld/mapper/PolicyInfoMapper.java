package com.example.helloworld.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.helloworld.mapper.BaseDao;
import com.example.helloworld.entity.PolicyInfo;

@Mapper
public interface PolicyInfoMapper extends BaseDao<PolicyInfo> {

}
