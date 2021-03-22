package com.daitda.backend.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Long> {
    @Query("SELECT p FROM Users p ORDER BY p.id DESC")
    List<Users> findAllDesc();

}
