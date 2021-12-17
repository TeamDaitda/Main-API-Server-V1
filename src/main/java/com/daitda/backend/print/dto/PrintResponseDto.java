package com.daitda.backend.print.dto;

import com.daitda.backend.print.domain.Print;
import lombok.Getter;

@Getter
public class PrintResponseDto {
    private final Long userId;
    private final String name;
    private final String phone;
    private final String path;

    public PrintResponseDto(Print entity) {
        this.userId = entity.getUsers().getId();
        this.name = entity.getUsers().getName();
        this.phone = entity.getUsers().getPhone();
        this.path = entity.getPath();
    }
}
