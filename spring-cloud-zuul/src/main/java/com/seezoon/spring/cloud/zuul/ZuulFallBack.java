package com.seezoon.spring.cloud.zuul;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 网关fallback
 * @author dfenghuang
 *
 */
@Component
public class ZuulFallBack implements FallbackProvider {

	@Override
	public String getRoute() {
		//过滤所有服务，如果是单个service 则写service名称
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8); //设置头
                return httpHeaders;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				//fallback 的原因 以及可以细化的降级码
				String text = "{'code':90000,'msg':" + cause.getMessage() + "}";
                return new ByteArrayInputStream(text.getBytes("UTF-8")); //返回前端的内容
			}
			
			@Override
			public String getStatusText() throws IOException {
				return HttpStatus.OK.getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.OK.value();
			}
			
			@Override
			public void close() {
				
			}
		};
	}

}
