package com.daitda.backend.image.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query("SELECT p FROM Image p ORDER BY p.id DESC")
    List<Image> findAllDesc();

    Image findByUsersId(Long users_id);
}
