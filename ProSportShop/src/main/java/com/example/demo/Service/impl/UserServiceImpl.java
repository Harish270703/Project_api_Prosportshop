package com.example.demo.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean addUser(User user) {
		boolean userExists = userRepository.existsByEmail(user.getEmail());
		if(!userExists) {
			userRepository.save(user);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<User> getUser() {
		return userRepository.findAll();
	}

	@Override
	public boolean updateUser(Long id,User user) {
//		userRepository.saveAndFlush(user);
		Optional<User> existingUserOptional = userRepository.findById(id);
		if(existingUserOptional.isPresent()) {
			User userExists = existingUserOptional.get();
			userExists.setFirstName(user.getFirstName());
			userExists.setLastName(user.getLastName());
			userExists.setEmail(user.getEmail());
			userExists.setPassword(user.getPassword());
			userRepository.save(userExists);
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean deleteUser(Long id) {
		System.out.println("Inside");
		Optional<User> existingUserOptional = userRepository.findById(id);
		if(existingUserOptional.isPresent()) {
			userRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Page<User> getAllUser(PageRequest pageRequest) {
		return userRepository.findAll(pageRequest);
	}
	
	@Override
	public String getFullName() {
		User user = new User();
		var userL = userRepository.findAll();
		String fName = userL.get(0).getFirstName();
		String lName = userL.get(0).getLastName();
		return user.getFullName(fName, lName);
	}

	@Override
	public List<String> getAllFullName() {
		List<User> userList = userRepository.findAll();
		User user = new User();
		List<String> fullNameList = new ArrayList<>();
		for(User userData: userList) {
			String fullName =  user.getFullName(userData.getFirstName(), userData.getLastName());
			fullNameList.add(fullName);
		}
		return fullNameList;
	}

	@Override
	public List<User> findAllQuery() {
		return userRepository.findAllQuery();
	}

	@Override
	public User getEmail(String email) {
		return userRepository.findByEmail(email);
	}

	
	@Override
	public int updateUserQuery(String firstName, Long id) {
		return userRepository.updateUser(firstName, id);
	}


	@Override
	public int deleteUserQuery(Long id) {
		return userRepository.deleteUser(id);
	}

	@Override
	public List<User> limitData() {
		return userRepository.findTop3ByOrderByFirstName();
	}

}