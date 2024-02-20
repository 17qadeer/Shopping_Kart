package com.shop.Shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.Shopping.Entity.TempUser;

@Repository
public interface TempUserRepository extends JpaRepository<TempUser, Long> {
    // Add any custom repository methods if needed
}
