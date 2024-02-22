package com.shop.Shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.Shopping.Entity.OrderItem;

@Repository
public interface OrderitemRepo extends JpaRepository<OrderItem, Long> {

}
