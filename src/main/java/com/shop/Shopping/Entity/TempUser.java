package com.shop.Shopping.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "GuestUser")
public class TempUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String address;
	private Long phoneNo;
	private String email;
	@OneToOne
	private Cart cart;
	public TempUser(Long id, String address, Long phoneNo, String email, Cart cart) {
		super();
		this.id = id;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.cart = cart;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "TempUser [id=" + id + ", address=" + address + ", phoneNo=" + phoneNo + ", email=" + email + ", cart="
				+ cart + "]";
	}
	

}
