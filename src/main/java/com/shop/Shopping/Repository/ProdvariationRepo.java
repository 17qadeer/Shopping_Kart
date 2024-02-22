package com.shop.Shopping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.Shopping.Entity.ProductVariation;

@Repository
public interface ProdvariationRepo extends JpaRepository<ProductVariation, Long> {

    @Query("SELECT pv FROM ProductVariation pv WHERE pv.name ILIKE CONCAT('%', :name, '%')")
    List<ProductVariation> findByNameContainingIgnoreCase(String name);

    @Query("SELECT pv FROM ProductVariation pv WHERE pv.type ILIKE CONCAT('%', :type, '%')")
    List<ProductVariation> findByTypeContainingIgnoreCase(String type);
}
