package com.shop.Shopping.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;




@Entity
public class SaveForLater {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private ProductVariation productVariation;
	private int quantity;
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
	public SaveForLater(Long id, ProductVariation productVariation, int quantity) {
		super();
		this.id = id;
		this.productVariation = productVariation;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "SaveForLater [id=" + id + ", productVariation=" + productVariation + ", quantity=" + quantity + "]";
	}
}
