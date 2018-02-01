package com.bin.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bin.web.common.DtoUtils;

@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String  test(){
		System.out.println("哈哈哈");
		return DtoUtils.isSuccess();
	}
}
