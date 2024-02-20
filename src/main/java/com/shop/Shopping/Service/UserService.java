package com.shop.Shopping.Service;


import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.shop.Shopping.Entity.TempUser;
import com.shop.Shopping.Entity.User;
import com.shop.Shopping.Repository.TempUserRepository;
import com.shop.Shopping.Repository.UserRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private TempUserRepository tempUserRepository;

    public User login(String username, String password) {
        return userRepository.findByUsername(username);
    }
    public User checkUser(String username, String password) {
        User u = userRepository.userDetails(username, password);
        if (u != null)
            return u;
        else
            return null;
    }

    public User signUp(User user) {
        // Check if the user already exists
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            return null; // User already exists, handle this case as needed (e.g., return error)
        }
        
        // Save the user to the database
        User savedUser = userRepository.save(user);

        // Transfer guest cart data to the signed-up user if exists
//        TempUser tempUser = tempUserRepository.findById(user.getId()).orElse(null);
//        if (tempUser != null) {
//            savedUser.setCartItem(tempUser.getCart()); // Transfer guest cart to signed-up user
//            tempUserRepository.delete(tempUser); // Remove the temporary user
 //       }

        return savedUser;
    }
    public List<User> finduser(String username) {
        return userRepository.findByusername(username);
    }
    public User updateProfile(User updatedUser) {
        // Retrieve the existing user from the database
        User existingUser = userRepository.findById(updatedUser.getId()).orElse(null);
        if (existingUser != null) {
            // Update the existing user's details
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setPhoneNo(updatedUser.getPhoneNo());
            existingUser.setAddress(updatedUser.getAddress());
            
            
            // Save the updated user back to the database
            return userRepository.save(existingUser);
        } else {
            // Handle case where the user does not exist
            return null;
        }
    }
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

  
}

