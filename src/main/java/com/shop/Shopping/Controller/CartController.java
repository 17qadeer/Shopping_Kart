package com.shop.Shopping.Controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shop.Shopping.Entity.Cart;
import com.shop.Shopping.Entity.User;
import com.shop.Shopping.Service.CartService;

import com.shop.Shopping.Service.UserService;
import com.shop.Shopping.exception.InsufficientQuantityException;
import com.shop.Shopping.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@Controller
public class CartController {

    @Autowired
    private CartService cartService;
// Assuming you have a ProductService to get product details

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addToCart(@ModelAttribute("productVariationId") Long productVariationId,
                            @ModelAttribute("quantity") int quantity,
                            RedirectAttributes redirectAttributes,
                            HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                try {
                    // Call the service method to add the product to the cart
                    Cart updatedCart = cartService.addToCart(user, productVariationId, quantity);
                    
                    redirectAttributes.addFlashAttribute("successMessage", "Product added to cart successfully");

                } catch (InsufficientQuantityException e) {
                    redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
                }
            } else {
                // User not found in session, redirect to signup or login
                return "redirect:/signup"; // or redirect to login page
            }
        } else {
            // Session not found, handle as appropriate, maybe redirect to login
            return "redirect:/signup";
        }

        return "redirect:/products/" + productVariationId;
    }




    // Add other controller methods for viewing cart, removing items, etc.

    // Exception handler method
    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handleResourceNotFoundException(ResourceNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", e.getMessage());
        modelAndView.setViewName("error"); // Assuming "error" is the view name for showing errors
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", "An unexpected error occurred.");
        modelAndView.setViewName("error"); // Assuming "error" is the view name for showing errors
        return modelAndView;
    }

    @GetMapping("/view")
    public ModelAndView viewCart(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                modelAndView.setViewName("redirect:/signup");
                return modelAndView;
            }
            Cart cart = cartService.viewCart(user);
            modelAndView.addObject("cart", cart);
            modelAndView.setViewName("cart"); // Assuming "cart" is the view name
        } catch (Exception e) {
            modelAndView.addObject("error", "An error occurred while viewing cart.");
            modelAndView.setViewName("error"); // Assuming "error" is the view name for showing errors
        }
        return modelAndView;
    }

    @PostMapping("/updateItemQuantity")
    public ModelAndView updateItemQuantity(@RequestParam Long cartItemId, @RequestParam int newQuantity, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                modelAndView.setViewName("redirect:/login");
                return modelAndView;
            }
            Cart cart = cartService.updateCartItemQuantity(user, cartItemId, newQuantity);
            modelAndView.addObject("cart", cart);
            modelAndView.setViewName("cart"); // Assuming "cart" is the view name
        } catch (Exception e) {
            modelAndView.addObject("error", "An error occurred while updating item quantity.");
            modelAndView.setViewName("error"); // Assuming "error" is the view name for showing errors
        }
        return modelAndView;
    }

    @PostMapping("/removeItem")
    public ModelAndView removeItem(@RequestParam Long cartItemId, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                modelAndView.setViewName("redirect:/login");
                return modelAndView;
            }
            Cart cart = cartService.removeCartItem(user, cartItemId);
            modelAndView.addObject("cart", cart);
            modelAndView.setViewName("cart"); // Assuming "cart" is the view name
        } catch (Exception e) {
            modelAndView.addObject("error", "An error occurred while removing item from cart.");
            modelAndView.setViewName("error"); // Assuming "error" is the view name for showing errors
        }
        return modelAndView;
    }

    @PostMapping("/clear")
    public ModelAndView clearCart(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                modelAndView.setViewName("redirect:/login");
                return modelAndView;
            }
            Cart cart = cartService.clearCart(user);
            modelAndView.addObject("cart", cart);
            modelAndView.addObject("message", "Cart cleared successfully.");
            modelAndView.setViewName("cart"); // Assuming "cart" is the view name
        } catch (Exception e) {
            modelAndView.addObject("error", "An error occurred while clearing cart.");
            modelAndView.setViewName("error"); // Assuming "error" is the view name for showing errors
        }
        return modelAndView;
    }
}
