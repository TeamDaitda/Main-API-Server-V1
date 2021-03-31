package com.daitda.backend.result.dto;

import com.daitda.backend.image.domain.Image;
import com.daitda.backend.result.domain.Result;
import com.daitda.backend.user.domain.Users;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ResultListResponseDto {
    private Long id;
    private Users users;
    private Image image;

    public ResultListResponseDto(Result entity) {
        this.id = entity.getId();
        this.users = entity.getUsers();
        this.image = entity.getImage();
    }
}
