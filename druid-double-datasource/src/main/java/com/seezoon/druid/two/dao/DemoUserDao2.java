package com.seezoon.druid.two.dao;

import org.apache.ibatis.annotations.Mapper;

import com.seezoon.druid.entity.DemoUser;

//@Mapper
public interface DemoUserDao2 {
    
    int deleteByPrimaryKey(String id);

    
    int insert(DemoUser record);

    
    int insertSelective(DemoUser record);

    
    DemoUser selectByPrimaryKey(String id);

    
    int updateByPrimaryKeySelective(DemoUser record);

    
    int updateByPrimaryKey(DemoUser record);
}