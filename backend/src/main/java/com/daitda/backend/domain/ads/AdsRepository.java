package com.daitda.backend.domain.ads;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdsRepository extends JpaRepository<Ads, Long> {
    @Query("SELECT p FROM Ads p ORDER BY p.id DESC")
    List<Ads> findAllDesc();
}
