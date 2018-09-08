package com.seezoon.druid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages= {"com.**.one.dao",},sqlSessionFactoryRef="sqlSessionFactoryOne")
public class MappScanConfig1 {

}
