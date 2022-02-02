package com.spring.springApi.service.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springApi.entity.User;
import com.spring.springApi.repository.UserRepository;

@Service
public class UserManager {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> addUsers(List<User> users){
		return userRepository.saveAll(users);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserByName(String name) {
		return userRepository.findUserByName(name);
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User updateUser(User user) {
		  User updateUser = userRepository.findById(user.getId()).orElse(null);
		    // crush the variables of the object found
		    updateUser.setAge(user.getAge());
		    updateUser.setEmail(user.getEmail());
		    updateUser.setName(user.getName());
		    userRepository.save(updateUser);
		    return user;
	}
	
	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "Kullanıcı Silindi";
	}
}
