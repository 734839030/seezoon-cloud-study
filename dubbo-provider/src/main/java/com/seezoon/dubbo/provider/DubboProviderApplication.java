package com.seezoon.dubbo.provider;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.container.Main;

@SpringBootApplication
@PropertySource(value= {"classpath:/dubbo.properties"})
@ImportResource(value= {"classpath:/dubbo.xml"})
public class DubboProviderApplication {

	public static void main(String[] args) {
		  new SpringApplicationBuilder(DubboProviderApplication.class)
          .web(WebApplicationType.NONE)
          .run(args);
		  //保留优雅关机特性
		  Main.main(args);
	}
}
