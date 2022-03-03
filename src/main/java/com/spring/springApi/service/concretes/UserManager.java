package com.spring.springApi.service.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springApi.core.result.DataResult;
import com.spring.springApi.core.result.ErrorDataResult;
import com.spring.springApi.core.result.ErrorResult;
import com.spring.springApi.core.result.Result;
import com.spring.springApi.core.result.SuccessDataResult;
import com.spring.springApi.core.result.SuccessResult;
import com.spring.springApi.entity.User;
import com.spring.springApi.repository.UserRepository;
import com.spring.springApi.service.abstracts.UserService;

@Service
public class UserManager implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	 

	@Override
	public DataResult<List<User>> getAll() {
		 try {
			 return new SuccessDataResult<List<User>>(
					this.userRepository.findAll(),"Listeleme başarılı" 
					 );
			 
		 }catch(Exception e)
		 {
			 return new ErrorDataResult("Listeleme başarısız");
		 }
	}

	@Override
	public DataResult<User> getByUsername(String username) {
		 try {
			 return new SuccessDataResult<User>(
					this.userRepository.findUserByUsername(username),"Listeleme başarılı" 
					 );
			 
		 }catch(Exception e)
		 {
			 return new ErrorDataResult("Listeleme başarısız");
		 }
	}

	@Override
	public Result saveAndFlush(User user) {
		 try {
			 this.userRepository.saveAndFlush(user);
			 return new SuccessResult("İşlem başarılı");
		 }catch(Exception e)
		 {
			 return new ErrorResult("İşlem başarılı");
		 }
	}
 
}
