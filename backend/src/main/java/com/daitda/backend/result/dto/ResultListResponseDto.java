package com.daitda.backend.result.dto;

import com.daitda.backend.result.domain.Result;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ResultListResponseDto {
    private Long id;
    private Long userId;
    private String name;
    private String phone;
    private int category;
    private String path;

    public ResultListResponseDto(Result entity) {
        this.id = entity.getId();
        this.userId = entity.getUsers().getId();
        this.name = entity.getUsers().getName();
        this.phone = entity.getUsers().getPhone();
        this.category = entity.getUsers().getCategory();
        this.path = entity.getImage().getPath();
    }
}
