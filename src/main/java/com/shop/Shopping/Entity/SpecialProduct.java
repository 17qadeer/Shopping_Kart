package com.shop.Shopping.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "SpcProduct")
public class SpecialProduct {
	@Id
    private Long sid;
	private String size;
    private String color;
    private int quantity;

    private String imageUrl;; 
    private String gender;
    private String type;
    private String description;
    private String name;
    private double price;
    private float discount;
    
    public SpecialProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpecialProduct(Long sid, String size, String color, int quantity, String imageUrl, String gender,
			String type, String description, String name, double price, float discount) {
		super();
		this.sid = sid;
		this.size = size;
		this.color = color;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
		this.gender = gender;
		this.type = type;
		this.description = description;
		this.name = name;
		this.price = price;
		this.discount = discount;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "SpecialProduct [sid=" + sid + ", size=" + size + ", color=" + color + ", quantity=" + quantity
				+ ", imageUrl=" + imageUrl + ", gender=" + gender + ", type=" + type + ", description=" + description
				+ ", name=" + name + ", price=" + price + ", discount=" + discount + "]";
	}
}
