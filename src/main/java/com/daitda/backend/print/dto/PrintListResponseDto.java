package com.daitda.backend.print.dto;

import com.daitda.backend.print.domain.Print;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PrintListResponseDto {
    private Long id;
    private Long userId;
    private String name;
    private String phone;
    private String path;

    public PrintListResponseDto(Print entity) {
        this.id = entity.getId();
        this.userId = entity.getUsers().getId();
        this.name = entity.getUsers().getName();
        this.phone = entity.getUsers().getPhone();
        this.path = entity.getPath();
    }
}
