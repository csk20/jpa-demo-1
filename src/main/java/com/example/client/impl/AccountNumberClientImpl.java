package com.example.client.impl;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.client.AccountNumberClient;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AccountNumberClientImpl  implements AccountNumberClient{
	
	@Autowired
	ConfigurableEnvironment environment;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public int getAccountNumber(int id) {
		
		String string=environment.getProperty("services.url");
		System.out.println("----------"+string);
		HttpHeaders headers=  getHeaders();
		HttpEntity<?> entity =new HttpEntity<>(headers);
		String url=new StringBuffer(string).append("/").toString();
		ResponseEntity<?> response=	restTemplate.exchange(url,HttpMethod.POST, entity,String.class);
		response.getBody();
		return 0;
	}

	
	public HttpHeaders getHeaders() {
		HttpHeaders headers= new HttpHeaders();
		headers.add("REQUEST_ID", MDC.get("REQUEST_ID"));
		headers.add("ContentType", "application/json");
		return headers;
		
	}
}
