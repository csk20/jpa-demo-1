package com.example.cache.profile;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class AppCache implements Serializable {
 
    private static final long serialVersionUID = 1L;
	
 private	String cacheId;
 private	String cacheName;

 private	Date createdDate= new Date();

}
