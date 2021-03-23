package com.daitda.backend.domain.adLogs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdLogsRepository extends JpaRepository<AdLogs, Long> {
    @Query("SELECT p FROM AdLogs p ORDER BY p.id DESC")
    List<AdLogs> findAllDesc();
}
