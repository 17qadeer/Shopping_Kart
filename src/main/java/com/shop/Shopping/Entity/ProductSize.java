package com.shop.Shopping.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_size")
public class ProductSize {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private long size;
	private long quantity;
	@ManyToOne
    @JoinColumn(name = "product_variation_id")
    private ProductVariation productVariation;
	public ProductSize() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductSize(long id, long size, long quantity, ProductVariation productVariation) {
		super();
		this.id = id;
		this.size = size;
		this.quantity = quantity;
		this.productVariation = productVariation;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public ProductVariation getProductVariation() {
		return productVariation;
	}
	public void setProductVariation(ProductVariation productVariation) {
		this.productVariation = productVariation;
	}
	@Override
	public String toString() {
		return "ProductSize [id=" + id + ", size=" + size + ", quantity=" + quantity + ", productVariation="
				+ productVariation + "]";
	}
	
	
	
	
}