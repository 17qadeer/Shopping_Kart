package com.shop.Shopping.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private ProductVariation productVariation;
	private int quantity;
	@ManyToOne
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(Long id, ProductVariation productVariation, int quantity, Cart cart, User user) {
		super();
		this.id = id;
		this.productVariation = productVariation;
		this.quantity = quantity;
		this.cart = cart;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductVariation getProductVariation() {
		return productVariation;
	}

	public void setProductVariation(ProductVariation productVariation) {
		this.productVariation = productVariation;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", productVariation=" + productVariation + ", quantity=" + quantity + ", cart="
				+ cart + ", user=" + user + "]";
	}

}
