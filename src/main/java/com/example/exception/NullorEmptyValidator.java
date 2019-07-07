package com.example.exception;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class NullorEmptyValidator implements ConstraintValidator<NullorEmpty, Object> {

	String fileName;
	int max;
	int min;

	@Override
	public void initialize(NullorEmpty constraintAnnotation) {
		this.fileName = constraintAnnotation.fileName();
		this.max = constraintAnnotation.max();
		this.min = constraintAnnotation.min();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		if (StringUtils.isEmpty(value)) {
			throw new InvalidInputException();
		}
		return true;

	}
}
