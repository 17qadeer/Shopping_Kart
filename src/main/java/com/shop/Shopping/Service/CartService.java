package com.shop.Shopping.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.*;
import com.shop.Shopping.Entity.Cart;
import com.shop.Shopping.Entity.CartItem;
import com.shop.Shopping.Entity.ProductVariation;
import com.shop.Shopping.Entity.User;
import com.shop.Shopping.Repository.CartItemRepo;
import com.shop.Shopping.Repository.CartRepo;
import com.shop.Shopping.Repository.ProdvariationRepo;
import com.shop.Shopping.exception.InsufficientQuantityException;
import com.shop.Shopping.exception.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepository;
    @Autowired
    private CartItemRepo cartItemRepository;

    @Autowired
    private ProdvariationRepo productVariationRepository;

    @Transactional
    public Cart addToCart(User user, Long productVariationId, int quantity) {
        // Find the product variation by ID
        ProductVariation productVariation = productVariationRepository.findById(productVariationId)
                .orElseThrow(() -> new NoSuchElementException("Product variation not found"));

        // Check if the product variation quantity is sufficient
        if (productVariation.getQuantity() < quantity) {
            throw new InsufficientQuantityException("Insufficient quantity available for the product variation");
        }

        // Get the user's cart, or create a new one if it doesn't exist
        Cart cart = user.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user); // Set the user for the cart
        }

        // Check if the cart already contains the product variation
        Optional<CartItem> existingCartItem = cart.getCartItems().stream()
                .filter(item -> item.getProductVariation().getId().equals(productVariationId))
                .findFirst();

        if (existingCartItem.isPresent()) {
            // If the product variation already exists in the cart, update the quantity
            CartItem cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItemRepository.save(cartItem); // Save the updated cart item
        } else {
            // If the product variation doesn't exist in the cart, create a new cart item
            CartItem newCartItem = new CartItem();
            newCartItem.setProductVariation(productVariation);
            newCartItem.setQuantity(quantity);
            newCartItem.setCart(cart); // Set the cart instance
            cart.getCartItems().add(newCartItem);
            cartItemRepository.save(newCartItem); // Save the new cart item
        }

        // Update the cart total price
        updateCartTotalPrice(cart);

        // Save the cart to the database
        return cartRepository.save(cart);
    }

    private void updateCartTotalPrice(Cart cart) {
        // Calculate the total price based on the cart items
        double totalPrice = cart.getCartItems().stream()
                .mapToDouble(item -> item.getProductVariation().getPrice() * item.getQuantity())
                .sum();
        cart.setTotalPrice(totalPrice);
    }

    public Cart viewCart(User user) {
        return user.getCart();
    }

    public Cart updateCartItemQuantity(User user, Long cartItemId, int newQuantity) {
        Cart cart = user.getCart();
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            if (cartItem.getId().equals(cartItemId)) {
                cartItem.setQuantity(newQuantity);
                // Update total price of the cart
                updateCartTotalPrice(cart);
                // Save the updated cart
                return cartRepository.save(cart);
            }
        }
        throw new ResourceNotFoundException("Cart item not found");
    }

    public Cart removeCartItem(User user, Long cartItemId) {
        Cart cart = user.getCart();
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            if (cartItem.getId().equals(cartItemId)) {
                cartItems.remove(cartItem);
                // Update total price of the cart
                updateCartTotalPrice(cart);
                // Save the updated cart
                return cartRepository.save(cart);
            }
        }
        throw new ResourceNotFoundException("Cart item not found");
    }

    public Cart clearCart(User user) {
        Cart cart = user.getCart();
        cart.getCartItems().clear();
        cart.setTotalPrice(0); // Reset total price
        return cartRepository.save(cart);
    }

 
    
}
