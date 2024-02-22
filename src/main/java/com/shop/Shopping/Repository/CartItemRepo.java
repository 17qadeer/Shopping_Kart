package com.shop.Shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.Shopping.Entity.Cart;
import com.shop.Shopping.Entity.CartItem;
import com.shop.Shopping.Entity.User;
@Repository
public interface CartItemRepo extends JpaRepository<CartItem,Long> {
	CartItem findByUser(User user);
}
