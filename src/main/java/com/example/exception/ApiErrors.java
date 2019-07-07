package com.example.exception;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="api-errors")
public class ApiErrors {
	 private static final long serialVersionUID = 1L;
	
	private List<ApiError> apiError;

	public List<ApiError> getApiError() {
		return apiError;
	}

	@XmlElement(name="api-error")
	public void setApiError(List<ApiError> apiError) {
		this.apiError = apiError;
	}

}
