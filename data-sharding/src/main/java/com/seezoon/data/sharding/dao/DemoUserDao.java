package com.seezoon.data.sharding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.seezoon.data.sharding.entity.DemoUser;

@Mapper
public interface DemoUserDao {
    
    int deleteByPrimaryKey(Long id);

    
    int insert(DemoUser record);

    
    int insertSelective(DemoUser record);

    
    DemoUser selectByPrimaryKey(Long id);
    List<DemoUser> selectList(DemoUser record);
    
    int updateByPrimaryKeySelective(DemoUser record);

    
    int updateByPrimaryKey(DemoUser record);
}