package com.daitda.backend.image.dto;

import com.daitda.backend.image.domain.Image;
import com.daitda.backend.user.domain.Users;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ImageListResponseDto {
    private Long id;
    private String path;
    private Users users;

    public ImageListResponseDto(Image entity) {
        this.id = entity.getId();
        this.path = entity.getPath();
        this.users = entity.getUsers();
    }
}
