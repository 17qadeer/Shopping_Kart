package com.shop.Shopping.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Order1")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems;
	private double totalPrice;
	private String shippingAddress;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Order(Long id, List<OrderItem> orderItems, double totalPrice, String shippingAddress, User user) {
		super();
		this.id = id;
		this.orderItems = orderItems;
		this.totalPrice = totalPrice;
		this.shippingAddress = shippingAddress;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", orderItems=" + orderItems + ", totalPrice=" + totalPrice + ", shippingAddress="
				+ shippingAddress + ", user=" + user + "]";
	}

}
