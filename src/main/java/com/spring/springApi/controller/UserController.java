package com.spring.springApi.controller;

 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springApi.core.result.DataResult;
import com.spring.springApi.core.result.Result;
import com.spring.springApi.entity.User;
import com.spring.springApi.service.abstracts.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/user")
@Api(value="User Rest Service")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
	
	@GetMapping("/getbyusername")
	public DataResult<User> getByUsername(String username)
	{
		return this.userService.getByUsername(username);
	}
	
	
	@PostMapping("/saveandflush")
	public Result saveAndFlush(@RequestBody User user) {
		return this.userService.saveAndFlush(user);
	}
	
	
	
	
}
