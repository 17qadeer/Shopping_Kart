package com.shop.Shopping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.Shopping.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	 User findByUsername(String username);

	List<User> findByusername(String username);
	

	@Query("from User where username=:username and password=:password")
	User userDetails(String username, String password);
}
