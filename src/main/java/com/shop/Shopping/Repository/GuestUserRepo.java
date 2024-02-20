package com.shop.Shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.Shopping.Entity.TempUser;

public interface GuestUserRepo extends JpaRepository<TempUser, Long> {

}
