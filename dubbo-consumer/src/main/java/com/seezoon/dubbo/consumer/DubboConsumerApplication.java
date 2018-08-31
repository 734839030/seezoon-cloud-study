package com.seezoon.dubbo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.ProtocolConfig;

@SpringBootApplication
@PropertySource(value= {"classpath:/dubbo.properties"})
@ImportResource(value= {"classpath:/dubbo.xml"})
public class DubboConsumerApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DubboConsumerApplication.class, args);
	}
	
	static {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				ProtocolConfig.destroyAll();
			}
		}));
	}
}
