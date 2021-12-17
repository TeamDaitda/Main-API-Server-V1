package com.daitda.backend.print.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrintRepository extends JpaRepository<Print, Long> {
    @Query("SELECT p FROM Print p ORDER By p.id DESC")
    List<Print> findAllDesc();

    Print findByUsersId(Long user_id);
}
