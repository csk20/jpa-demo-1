package com.example.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class XmlParserImpl {
	
	public static Map<String,ApiError> map=new HashMap<>();
	
	@Autowired
	ErrorParserImpl errorParserImpl;

	
	
	
	@PostConstruct
public	void init() {
	try {
		if(map==null ||  map.isEmpty()) {
			log.info("in XmlParserImpl init in");
			
		ApiErrors	apiErrors= (ApiErrors) errorParserImpl.converXmlToObject();
		System.out.println("----------------");
		System.out.println(apiErrors.getApiError().size());
		
		System.out.println("----------------");
		putToMap(apiErrors);
		log.info("in XmlParserImpl init out ");
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


	public void putToMap(ApiErrors apiErrors) {
		
	//	ApiError ApiError= new ApiError();
		
	//	if(apiErrors !=null &&  apiErrors.getApiError() !=null && !apiErrors.getApiError().isEmpty()) {
		for(ApiError apiError :apiErrors.getApiError()) {
			System.out.println(apiError.getErrorId());
			System.out.println(apiError.getErrorMsg());
			System.out.println(apiError.getErrorCode());
			map.put(apiError.getErrorId(), apiError);
		}
		//}
	}
		// TODO Auto-generated method stub
		
		public ApiError requsetMsg(String msg) {
		//	ApiError apiError=new ApiError();
			//apiError.set
			System.out.println(msg);
	return	map.get(msg);
		
	}

}
