package com.daitda.backend.result.dto;

import com.daitda.backend.image.domain.Image;
import com.daitda.backend.result.domain.Result;
import com.daitda.backend.user.domain.Users;
import lombok.Getter;

@Getter
public class ResultResponseDto {
    private final Long userId;
    private final String name;
    private final String phone;
    private final int category;
    private final String path;

    public ResultResponseDto(Result entity){

        this.userId = entity.getUsers().getId();
        this.name = entity.getUsers().getName();
        this.phone = entity.getUsers().getPhone();
        this.category = entity.getUsers().getCategory();
        this.path = entity.getImage().getPath();
    }
}
