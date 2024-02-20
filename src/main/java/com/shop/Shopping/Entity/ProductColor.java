package com.shop.Shopping.Entity;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "product_color")
public class ProductColor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private String color;
	private String primaryColor;
	private String secondaryColor;
	private String url;
	
	@ManyToOne
    @JoinColumn(name = "product_variation_id")
    private ProductVariation productVariation;
	
 
	public ProductColor() {
		super();
	}
	
 
 
	public ProductColor(long id, String color, String primaryColor, String secondaryColor, String url,
			ProductVariation productVariation) {
		super();
		this.id = id;
		this.color = color;
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.url = url;
		this.productVariation = productVariation;
	}
 
 
 
	public long getId() {
		return id;
	}
 
 
	public void setId(long id) {
		this.id = id;
	}
 
 
	public String getColor() {
		return color;
	}
 
 
	public void setColor(String color) {
		this.color = color;
	}
 
 
	public String getPrimaryColor() {
		return primaryColor;
	}
 
 
	public void setPrimaryColor(String primaryColor) {
		this.primaryColor = primaryColor;
	}
 
 
	public String getSecondaryColor() {
		return secondaryColor;
	}
 
 
	public void setSecondaryColor(String secondaryColor) {
		this.secondaryColor = secondaryColor;
	}
 
 
	public String getUrl() {
		return url;
	}
 
 
	public void setUrl(String url) {
		this.url = url;
	}
 
 
	public ProductVariation getProductVariation() {
		return productVariation;
	}
 
 
	public void setProductVariation(ProductVariation productVariation) {
		this.productVariation = productVariation;
	}
 
 
	@Override
	public String toString() {
		return "ProductColors [id=" + id + ", color=" + color + ", primaryColor=" + primaryColor + ", secondaryColor="
				+ secondaryColor + ", url=" + url + ", productVariation=" + productVariation + "]";
	}
 
	
}

