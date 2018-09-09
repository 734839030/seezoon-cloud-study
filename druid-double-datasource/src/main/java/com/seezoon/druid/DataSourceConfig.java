package com.seezoon.druid;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
public class DataSourceConfig {

	@Value("${mybatis.mapper-locations}")
	 private Resource[] mapperLocations;
	@Primary
	@Bean("dataSourceOne")
	@ConfigurationProperties("spring.datasource.druid.one")
	public DataSource dataSourceOne(){
	    return DruidDataSourceBuilder.create().build();
	}
	@Primary
	@Bean("sqlSessionFactoryOne")
	public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("dataSourceOne")  DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		
		//sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappings/*.xml"));
		sessionFactory.setMapperLocations(mapperLocations);//上面的写法也可以
		//sessionFactory.setConfigLocation(configLocation);//分页插件 拦截器在这个配置文件中
		return sessionFactory.getObject();
	}
	
	@Bean("dataSourceTwo")
	@ConfigurationProperties("spring.datasource.druid.two")
	public DataSource dataSourceTwo(){
	    return DruidDataSourceBuilder.create().build();
	}
	@Bean("sqlSessionFactoryTwo")
	public SqlSessionFactory sqlSessionFactoryTwo(@Qualifier("dataSourceTwo")  DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setMapperLocations(mapperLocations);
		//sessionFactory.setConfigLocation(configLocation);
		return sessionFactory.getObject();
	}
}
