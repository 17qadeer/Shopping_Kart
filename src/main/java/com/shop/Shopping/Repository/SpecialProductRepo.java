package com.shop.Shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.Shopping.Entity.SpecialProduct;
@Repository
public interface SpecialProductRepo extends JpaRepository<SpecialProduct, Long> {
		
	}
