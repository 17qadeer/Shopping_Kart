package com.shop.Shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.Shopping.Entity.Cart;
import com.shop.Shopping.Entity.User;
@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
	

    @Query("SELECT c FROM Cart c WHERE c.user = ?1")
    Cart findByUser(User user);
}

