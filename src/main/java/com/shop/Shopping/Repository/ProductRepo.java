package com.shop.Shopping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.Shopping.Entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}



