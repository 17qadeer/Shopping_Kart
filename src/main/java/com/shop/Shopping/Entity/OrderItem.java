package com.shop.Shopping.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private ProductVariation productVariation;
	private int quantity;
	@ManyToOne
	private Order order;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(Long id, ProductVariation productVariation, int quantity, Order order) {
		super();
		this.id = id;
		this.productVariation = productVariation;
		this.quantity = quantity;
		this.order = order;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", productVariation=" + productVariation + ", quantity=" + quantity + ", order="
				+ order + "]";
	}

}
