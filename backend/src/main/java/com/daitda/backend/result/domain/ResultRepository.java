package com.daitda.backend.result.domain;

import com.daitda.backend.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    @Query("SELECT p FROM Result p ORDER By p.id DESC")
    List<Result> findAllDesc();

    List<Result> findByUsersId(Long users_id);
}