package com.daitda.backend.result.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResultSaveRequestDto {
    private final Long userId;

    @Builder
    public ResultSaveRequestDto(Long userId) {
        this.userId = userId;
    }
}