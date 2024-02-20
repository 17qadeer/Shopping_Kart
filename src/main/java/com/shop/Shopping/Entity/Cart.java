package com.shop.Shopping.Entity;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@jakarta.persistence.Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double TotalPrice;
	@OneToOne
	private CartItem cartItem;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartItem> cartItems = new ArrayList<>(); 

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Cart(Long id, double totalPrice, CartItem cartItem, User user, List<CartItem> cartItems) {
		super();
		this.id = id;
		TotalPrice = totalPrice;
		this.cartItem = cartItem;
		this.user = user;
		this.cartItems = cartItems;
	}



	public Cart(double totalPrice) {
		super();
		TotalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	

	public double getTotalPrice() {
		return TotalPrice;
	}



	public void setTotalPrice(double totalPrice) {
		TotalPrice = totalPrice;
	}



	public CartItem getCartItem() {
		return cartItem;
	}



	public void setCart(CartItem cartItem) {
		this.cartItem = cartItem;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Cart [id=" + id + ", TotalPrice=" + TotalPrice + ", cartItem=" + cartItem + ", user=" + user + ", cartItems="
				+ cartItems + "]";
	}

}
