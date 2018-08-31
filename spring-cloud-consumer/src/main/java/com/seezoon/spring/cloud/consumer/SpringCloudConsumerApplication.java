package com.seezoon.spring.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
/**
 * 加了熔断的例子，其实一般在zuul上做，特殊需求可以在消费端细化
 * @author dfenghuang
 *
 */
public class SpringCloudConsumerApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConsumerApplication.class, args);
	}
}
