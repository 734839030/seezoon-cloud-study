package com.seezoon.druid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages= {"com.**.two.dao"},sqlSessionFactoryRef="sqlSessionFactoryTwo")
public class MappScanConfig2 {

}
