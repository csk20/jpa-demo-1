
  package com.example.controller;
  
  import java.util.ArrayList; import java.util.List; import java.util.Map;
  
  import org.springframework.stereotype.Controller; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.RequestMapping; import
  org.springframework.web.bind.annotation.RequestMethod; import
  org.springframework.web.bind.annotation.RestController;
  
  import com.example.vo.User;
  
  @Controller
  @RequestMapping("/v3") 
  public class UserController {
  
  
  
  @RequestMapping(value="/",method = RequestMethod.GET,produces=
  {"application/json"}) public String welcome(Map<String,Object> map) {
  map.put("name","Chandan");
  
  return "welcome"; }
  
  
  
  @RequestMapping( value= "/name/{name}", produces= {"application/json"}
  ,method = RequestMethod.GET) 
  public String welcome(Map<String,Object>
  map, @PathVariable("name") String name) { map.put("name",name); return
  "welcome"; }
  
  
  
  @RequestMapping(value="/list",method = RequestMethod.GET,produces=
  {"application/json"}) 
  public String listAll(Map<String,Object> map) {
  List<String> list= new ArrayList<>(); list.add("Ram"); list.add("Chandan");
  map.put("listAll", list); return "list"; }
  
  
  }
 