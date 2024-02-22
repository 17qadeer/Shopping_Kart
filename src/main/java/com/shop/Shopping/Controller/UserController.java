package com.shop.Shopping.Controller;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.shop.Shopping.Entity.User;
import com.shop.Shopping.Entity.TempUser;
import com.shop.Shopping.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping("/signup")
    public String getsignup() {
        return "signup";
    }
    
    @RequestMapping("/")
    public String gethome() {
        return "home";
    }

    @PostMapping("/login")
    public String login(@RequestParam(required = false) String username, 
                        @RequestParam(required = false) String password, 
                        HttpSession session) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            session.setAttribute("user", user); // Store user in session
            return "home";
        } else {
            return "signup";
        }
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam String username, 
                         @RequestParam String email, 
                         @RequestParam String password,
                         HttpSession session) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        
        User signedUpUser = userService.signUp(user);
        if (signedUpUser != null) {
            session.setAttribute("user", signedUpUser); // Store signed up user in session
            return "home";
        } else {
            return "signup";
        }
    }
    
    @RequestMapping("/profile")
    public String userProfile(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            // Fetch user details from the database and add to the model
            model.addAttribute("user", user);
            return "profile";
        } else {
            model.addAttribute("msg", "Please log in to view the profile");
            return "redirect:/signup"; // Redirect to signup page if user is not logged in
        }
    }

    @GetMapping("/editprofile")
    public String showEditProfilePage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user); // Add user details to the model
            return "editprofile";
        } else {
            model.addAttribute("msg", "Please log in to edit your profile");
            return "redirect:/signup"; // Redirect to signup page if user is not logged in
        }
    }
    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute("user") User updatedUser, HttpSession session, Model model) {
        // Retrieve the currently logged-in user from the session
        User loggedInUser = (User) session.getAttribute("user");
        if (loggedInUser != null) {
            // Set the ID of the updated user to match the ID of the logged-in user
            updatedUser.setId(loggedInUser.getId());
            
            // Update the user's profile in the database
            User updatedUserProfile = userService.updateProfile(updatedUser);
            
            // Update the user information stored in the session with the updated user object
            session.setAttribute("user", updatedUserProfile);
            
            // Add user details to the model
            model.addAttribute("user", updatedUserProfile);
            
            // Redirect to profile page with updated user details
            return "profile";
        } else {
            // Handle case where user is not logged in
            model.addAttribute("msg", "Please log in to update your profile");
            return "redirect:/signup";
        }
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate session to logout user
        return "home";
    }
}
