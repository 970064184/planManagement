package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.User;

@RestController
public class TestController {

	@GetMapping("/test")
	public String test(String name,String key){
		return name + key;
	}
	
	@PostMapping("/test/user")
	public String user(@RequestBody User user){
		return user.toString();
	}
	
	@PostMapping("/test/user1")
	public String user1(User user){
		return user.toString();
	}
	
}
