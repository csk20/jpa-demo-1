package com.example.exception;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Documented
	@Constraint(validatedBy = NullorEmptyValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,ElementType.CONSTRUCTOR,
    ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
	public @interface NullorEmpty {
	    String message() default "Invalid phone number";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
		
	    String fileName();
	    int min() default 0  ;
	    int max() default Integer.MAX_VALUE;
	
	    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
	        ElementType.ANNOTATION_TYPE})
	    @Retention(RetentionPolicy.RUNTIME)
	    @interface List {
	       
	    	NullorEmpty[] value();
	    
}
	    
	    
	    
}
