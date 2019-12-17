package com.dbs.messagingqueue.messagingqueueapi.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class QueueExceptionHandler  extends ResponseEntityExceptionHandler{
	
	  @ExceptionHandler({RuntimeException.class})
	    public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
	        return error(INTERNAL_SERVER_ERROR, e);
	    }
	    @ExceptionHandler({QueueServiceException.class})
	    public ResponseEntity<String> handleNotFoundException(QueueServiceException e) {
	        return error(HttpStatus.BAD_REQUEST, e);
	    }

	
	    private ResponseEntity<String> error(HttpStatus status, Exception e) {
	   
	        return ResponseEntity.status(status).body(e.getMessage());
	    }
	

		@Override
		protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
		
			
			
			return  new ResponseEntity<Object>("Media Type Not Supported",status.BAD_REQUEST);
		
		}
		
		
		@Override
		protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			HttpStatus status1=	status.ACCEPTED;
			
			return new ResponseEntity<Object>("Media Type Not Acceptable",status.BAD_REQUEST);//super.handleHttpMediaTypeNotAcceptable(ex, headers, status1, request);
		}
}
