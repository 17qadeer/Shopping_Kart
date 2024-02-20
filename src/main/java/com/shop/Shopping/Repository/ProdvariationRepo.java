package com.shop.Shopping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.Shopping.Entity.ProductVariation;

@Repository
public interface ProdvariationRepo extends JpaRepository<ProductVariation, Long> {

	List<ProductVariation> findByNameIgnoreCaseStartingWith(String name);

	List<ProductVariation> findByTypeIgnoreCase(String type);

}
