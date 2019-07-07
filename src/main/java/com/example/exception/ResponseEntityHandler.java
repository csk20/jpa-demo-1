package com.example.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.response.vo.ResponseOutput;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ResponseEntityHandler extends ResponseEntityExceptionHandler{

	
	@Autowired
	XmlParserImpl xmlParserImpl;
	
	
	@Override
	protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex,
			HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
		
		xmlParserImpl.requsetMsg("error.invalid");
		return super.handleAsyncRequestTimeoutException(ex, headers, status, webRequest);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		//HttpStatus status1.s=	status.ACCEPTED;
		log.info("in exception handler not supported");
	//	System.out.println(xmlParserImpl.requsetMsg("error.invalid"));
		
		ApiError error=		xmlParserImpl.requsetMsg("error.invalid");
		
		ResponseOutput response= new ResponseOutput();
		response.setErrorId(error.getErrorId()); response.setErrorCode(error.getErrorCode()); response.setErrorMsg(error.getErrorMsg());
	//
		return  new ResponseEntity<Object>(response,status.BAD_REQUEST);
				// super.handleHttpMediaTypeNotSupported(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		HttpStatus status1=	status.ACCEPTED;
		log.info("in exception handler not acceptable");
		xmlParserImpl.requsetMsg("error.invalid");
		return new ResponseEntity<Object>(status.OK);//super.handleHttpMediaTypeNotAcceptable(ex, headers, status1, request);
	}
}
