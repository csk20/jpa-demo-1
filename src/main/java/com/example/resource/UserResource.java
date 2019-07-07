package com.example.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.client.impl.AccountNumberClientImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(value = "Swagger2DemoRestController", description = "REST APIs related to Student Entity!!!!")
@Controller
@RequestMapping("/v1")
public class UserResource {
	@Autowired
	AccountNumberClientImpl accountNumberClientImpl;
	
	@ApiOperation(value = "Get list of Students in the System ", response = String.class, tags = "getStudents")
	
	@ApiResponses(value= {
	@ApiResponse(code=200,message="Created sussessfully"),
	@ApiResponse(code=401,message="UnAuthorized"),
	@ApiResponse(code=403,message="Forbidden"),
	@ApiResponse(code=404,message="Resource not Found")
	})
	@RequestMapping(value="/",method = RequestMethod.GET,produces= {"application/json"})
	public String welcome(Map<String,Object> map) {
		map.put("name","Chandan");
		int x=	accountNumberClientImpl.getAccountNumber(1);
		return "welcome";
	}

	
	@ApiOperation(value="name path variables", response = String.class, tags = "getStudents")
	@ApiResponses(value= {
	@ApiResponse(code=200,message="Created sussessfully"),
	@ApiResponse(code=401,message="UnAuthorized"),
	@ApiResponse(code=403,message="Forbidden"),
	@ApiResponse(code=404,message="Resource not Found")
	})
	@RequestMapping( value= "/name/{name}", produces= {"application/json"} ,method = RequestMethod.GET)
	public String welcome(Map<String,Object> map, @PathVariable("name") String name) {
		map.put("name",name);
		int x=	accountNumberClientImpl.getAccountNumber(1);
				return "welcome";
	}
	
@ApiOperation(value="List all value")
	@ApiResponses(value= {
	@ApiResponse(code=200,message="Created sussessfully"),
	@ApiResponse(code=401,message="UnAuthorized"),
	@ApiResponse(code=403,message="Forbidden"),
	@ApiResponse(code=404,message="Resource not Found")
	})
	@RequestMapping(value="/list",method = RequestMethod.GET,produces= {"application/json"})
	public String listAll(Map<String,Object> map) {
		List<String> list= new ArrayList<>();
		list.add("Ram");
		list.add("Chandan");
	int x=	accountNumberClientImpl.getAccountNumber(1);
	System.out.println(x);
		map.put("listAll", list);
		return "list";
	}
	

}
