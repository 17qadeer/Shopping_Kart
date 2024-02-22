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
        // ... existing code to find product variation and check quantity ...

        // Get existing cart for user (if any)
        Cart existingCart = cartRepository.findByUser(user);

        if (existingCart != null) {
            // Update existing cart
            updateCartItemQuantity(existingCart, productVariationId, quantity);
            cartRepository.save(existingCart);
        } else {
            // Create new cart if none exists
            existingCart = createNewCart(user, productVariationId, quantity);
            cartRepository.save(existingCart);
        }

        // Update cart total price
        updateCartTotalPrice(existingCart);

        return existingCart;
    }

    private void updateCartItemQuantity(Cart cart, Long productVariationId, int quantity) {
        // Find existing cart item for the product variation
        Optional<CartItem> existingCartItem = cart.getCartItems().stream()
                .filter(item -> item.getProductVariation().getId().equals(productVariationId))
                .findFirst();

        if (existingCartItem.isPresent()) {
            // Update quantity
            existingCartItem.get().setQuantity(existingCartItem.get().getQuantity() + quantity);
        } else {
            // Create new cart item
            CartItem newItem = new CartItem();
            newItem.setProductVariation(productVariationRepository.findById(productVariationId).get());
            newItem.setQuantity(quantity);
            newItem.setCart(cart);
            cart.getCartItems().add(newItem);
        }
    }

    private Cart createNewCart(User user, Long productVariationId, int quantity) {
        Cart newCart = new Cart();
        newCart.setUser(user);
        // Add cart item to new cart
        CartItem newItem = new CartItem();
        newItem.setProductVariation(productVariationRepository.findById(productVariationId).get());
        newItem.setQuantity(quantity);
        newItem.setCart(newCart);
        newCart.getCartItems().add(newItem);
        return newCart;
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
