package com.daitda.backend.print.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PrintSaveRequestDto {
    private final Long userId;
    private final String path;

    @Builder
    public PrintSaveRequestDto(Long userId, String path) {
        this.userId = userId;
        this.path = path;
    }
}
