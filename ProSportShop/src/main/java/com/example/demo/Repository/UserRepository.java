package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long>{

	boolean existsByEmail(String email);
	
	Optional<User> findById(Long id);
	
	void deleteById(Long id);
	
	List<User> findTop3ByOrderByFirstName();
	
//	Without using nativeQuery
	
//	@Query("select u from User u")
//	List<User> findAllQuery();
	
//	@Query("select u from User u where u.email = :e")
//	User findByEmail(@Param("e") String email);
//	
//	@Query("select u from User u where u.email = ?1")
//	User findByEmail(String email);
	
//	@Modifying
//	@Transactional
//	@Query("update User u set u.firstName = :fName where u.id = :id")
//	void updateUser(@Param("fName") String fname, @Param("id") Long id);
	
//	@Modifying
//	@Transactional
//	@Query("update User u set u.firstName = :fName where u.id = :id")
//	int updateUser(@Param("fName") String fname, @Param("id") Long id);
	
//	@Modifying
//	@Transactional
//	@Query("delete User u where u.id = ?1")
//	void deleteUser(Long id);
	
//	@Modifying
//	@Transactional
//	@Query("delete User u where u.id = ?1")
//	int deleteUser(Long id);
	
//	With using nativeQuery
	
	@Query(value = "select * from user", nativeQuery = true)
	List<User> findAllQuery(); 
	
	@Query(value = "select * from user where email = ?1", nativeQuery = true)
	User findByEmail(String email);
	
	@Modifying
	@Transactional
	@Query(value = "update user set first_name = :fName where id = :id", nativeQuery = true)
	int updateUser(@Param("fName") String fname, @Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query(value = "delete from user where id = ?1", nativeQuery = true)
	int deleteUser(Long id);

}