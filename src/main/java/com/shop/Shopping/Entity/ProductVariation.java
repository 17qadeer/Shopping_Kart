package com.shop.Shopping.Entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ProductVariation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String color;
    private int quantity;
    private String imageUrl;; 
    private String gender;
    private String type;
    private String description;
    private String name;
    private double price;
    private float discount;
    @ManyToOne
    private Product product;
    
    @OneToMany
    private List<ProductSize> productSize = new ArrayList<>(); 
    
    @OneToMany
    private List<ProductColor> productColor = new ArrayList<>(); 

    public ProductVariation() {
        super();
        // TODO Auto-generated constructor stub
    }





	public ProductVariation(Long id, String color, int quantity, String imageUrl, String gender,
			String type, String description, String name, double price, float discount, Product product,
			List<ProductSize> productSize, List<ProductColor> productColor) {
		super();
		this.id = id;
	
		this.color = color;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
		this.gender = gender;
		this.type = type;
		this.description = description;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.product = product;
		this.productSize = productSize;
		this.productColor = productColor;
	}





	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getColor() {
        return color;
    }

    public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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




	public List<ProductSize> getProductSize() {
		return productSize;
	}





	public void setProductSize(List<ProductSize> productSize) {
		this.productSize = productSize;
	}





	public List<ProductColor> getProductColor() {
		return productColor;
	}





	public void setProductColor(List<ProductColor> productColor) {
		this.productColor = productColor;
	}





	@Override
	public String toString() {
		return "ProductVariation [id=" + id + ", color=" + color + ", quantity=" + quantity
				+ ", imageUrl=" + imageUrl + ", gender=" + gender + ", type=" + type + ", description=" + description
				+ ", name=" + name + ", price=" + price + ", discount=" + discount + ", product=" + product
				+ ", productSize=" + productSize + ", productColor=" + productColor + "]";
	}
}
