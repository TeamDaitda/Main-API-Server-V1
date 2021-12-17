package com.daitda.backend.advertisement_log.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdLogsRepository extends JpaRepository<AdLogs, Long> {
    @Query("SELECT p FROM AdLogs p ORDER BY p.id DESC")
    List<AdLogs> findAllDesc();

    List<AdLogs> findByUsersId(Long users_id);
    List<AdLogs> findByAdsId(Long ads_id);
}
