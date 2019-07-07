package com.example.exception;

import java.io.InputStream;

import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ErrorParserImpl {
	
	private Unmarshaller unmarshaller;
		
	public Unmarshaller getUnmarshaller() {
		return unmarshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public Object converXmlToObject()  {
		
		log.info("----------in converXmlToObject method");
		try (InputStream is = this.getClass().getResourceAsStream("/api-errors.xml")) {
			return 	getUnmarshaller().unmarshal(new StreamSource(is));
			} catch (Exception e) {
			e.printStackTrace();
			log.error("in catch block  converXmlToObject");
			}		
			return null;
	}
}
