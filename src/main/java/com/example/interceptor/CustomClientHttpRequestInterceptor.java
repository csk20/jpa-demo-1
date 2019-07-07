package com.example.interceptor;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		 requestDetails(request);
		 log.info("in {}"+"CustomClientHttpRequestInterceptor");
	     return execution.execute(request, body);
	
	 
	}
	

 private void requestDetails(HttpRequest request) {
     log.info("Headers: {}", request.getHeaders());
     log.info("Request Method: {}", request.getMethod());
     log.info("Request URI: {}", request.getURI());
     log.info("out {}"+"requestDetails");
 }

}
