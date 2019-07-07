package com.example.interceptor;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AppFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletResponse resp = (HttpServletResponse) response;
	        HttpServletRequest req = (HttpServletRequest) request;
	        log.info(
	          "Starting a transaction for req : {}", 
	          req.getRequestURI());
	     
	        chain.doFilter(request, response);
	        log.info(
	          "Committing a transaction for req : {}", 
	          req.getRequestURI());
	    }
	 

	}


