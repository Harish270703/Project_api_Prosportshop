package com.example.demo.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.Model.User;

public interface UserService {
	public boolean addUser(User user);
	public List<User> getUser();
	public boolean updateUser(Long id, User user);
	public boolean deleteUser(Long id);
	public Page<User> getAllUser(PageRequest pageRequest);
	public String getFullName();
	public List<String> getAllFullName();
	List<User> findAllQuery();
	public User getEmail(String email);
//	public void updateUserQuery(String firstName, Long id);
	public int updateUserQuery(String firstName, Long id);
//	public void deleteUserQuery(Long id);
	public int deleteUserQuery(Long id);
	public List<User> limitData();
}