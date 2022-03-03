package com.spring.springApi.service.abstracts;

import java.util.List;

import com.spring.springApi.core.result.DataResult;
import com.spring.springApi.core.result.Result;
import com.spring.springApi.entity.User;

public interface UserService {
	DataResult<List<User>> getAll();
	DataResult<User> getByUsername(String username);
	
	Result saveAndFlush(User user);
}
