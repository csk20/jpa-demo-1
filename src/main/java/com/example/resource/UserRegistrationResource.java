package com.example.resource;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.request.vo.UserRegistrationInput;
import com.example.response.vo.UserRegistrationOutput;
import com.example.service.UserRegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/v2")
@Slf4j
public class UserRegistrationResource {
	
   @Autowired
	UserRegistrationService  userRegistrationService;
	
	@ApiOperation(value="UserRegistration", response = UserRegistrationOutput.class, tags = "User Registration")
	@ApiResponses(value= {
	@ApiResponse(code=200,message="Created sussessfully"),
	@ApiResponse(code=401,message="UnAuthorized"),
	@ApiResponse(code=403,message="Forbidden"),
	@ApiResponse(code=404,message="Resource not Found")
	})
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "REQUEST_ID", value = "REQUEST_ID", required = true, dataType = "String", paramType = "header"),
	  //  @ApiImplicitParam(name = "email", value = "User's email", required = false, dataType = "string", paramType = "query"),
	  //  @ApiImplicitParam(name = "id", value = "User ID", required = true, dataType = "long", paramType = "query")
	  })
	@RequestMapping( value= "/register", produces= {"application/json"},consumes= {"application/json"} ,method = RequestMethod.POST)
	public UserRegistrationOutput welcome( @ApiParam(value = "UserRegistrationInput", required = true)@RequestBody UserRegistrationInput input,HttpServletRequest request) {
		UserRegistrationOutput userRegistrationOutput;
	
	MDC.put("REQUEST_ID",request.getHeader("REQUEST_ID"));
		userRegistrationOutput=	userRegistrationService.registration(input);
		log.info("request id is "+MDC.get("REQUEST_ID"));
		log.info("-----env  id is "+System.getenv());
		
		return userRegistrationOutput;
	}
	
	
	

}
