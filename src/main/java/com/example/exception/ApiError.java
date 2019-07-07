package com.example.exception;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="api-error")
public class ApiError {
	
	 private static final long serialVersionUID = 1L;
	 
	private String errorId;
	
	private  String errorMsg;
	
	private  String errorCode;
	 
	
	 
	// String requestId;

	public String getErrorId() {
		return errorId;
	}

	@XmlAttribute(name="errorId")
	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}


	public String getErrorMsg() {
		return errorMsg;
	}

	@XmlAttribute(name="errorMsg")
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	

	public String getErrorCode() {
		return errorCode;
	}

	@XmlAttribute(name="errorCode")
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/*
	 * public String getRequestId() { return requestId; }
	 * 
	 * public void setRequestId(String requestId) { this.requestId = requestId; }
	 */
	 
	 
}
