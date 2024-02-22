package com.shop.Shopping.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;




@Entity
public class SaveForLater {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private ProductVariation productVariation;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
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

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public SaveForLater(Long id, ProductVariation productVariation, User user) {
		super();
		this.id = id;
		this.productVariation = productVariation;
		this.user = user;
	}
	@Override
	public String toString() {
		return "SaveForLater [id=" + id + ", productVariation=" + productVariation + ", user=" + user + "]";
	}
}
