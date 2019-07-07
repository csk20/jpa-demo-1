package com.example.config;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.example.exception.ApiErrors;
import com.example.exception.ErrorParserImpl;
import com.example.interceptor.AppFilter;
import com.example.interceptor.CustomClientHttpRequestInterceptor;

@Configuration
@ComponentScan("com.example")
@EnableAsync
public class AppConfig {

	@Autowired
	private ConfigurableEnvironment environment;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
		builder.interceptors(new CustomClientHttpRequestInterceptor());
	   return builder.build();
	}
	
	

	@Bean
	public Jaxb2Marshaller getMarshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setClassesToBeBound( ApiErrors.class );
		return jaxb2Marshaller;
	}

	@Bean
	public FilterRegistrationBean<AppFilter> loggingFilter() {
		FilterRegistrationBean<AppFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new AppFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1);
		return registrationBean;
	}

	@Bean
	public ErrorParserImpl errorParser() {
		ErrorParserImpl errorParserImpl = new ErrorParserImpl();
		errorParserImpl.setUnmarshaller(getMarshaller());
		return errorParserImpl;
	}

	@Autowired
	public void initialise(ConfigurableEnvironment env) {
		this.environment = env;
	}
	
	public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("async--");
        executor.initialize();
        return executor;
    }

}
