package com.daitda.backend.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT p FROM Users p ORDER BY p.id DESC")
    List<Users> findAllDesc();

    @Query("SELECT p FROM Users p WHERE p.name = :name")
    List<Users> findByName(String name);
}
