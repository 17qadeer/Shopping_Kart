package com.shop.Shopping.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float discount;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id,  float discount) {
		super();
		this.id = id;
		this.discount = discount;
	}
	

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	@Override
	public String toString() {
		return "Product [id=" + id + ", discount=" + discount + "]";
	}

}
