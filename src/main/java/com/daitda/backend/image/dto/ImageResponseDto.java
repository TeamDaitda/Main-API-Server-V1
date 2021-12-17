package com.daitda.backend.image.dto;

import com.daitda.backend.image.domain.Image;
import com.daitda.backend.user.domain.Users;
import lombok.Getter;

@Getter
public class ImageResponseDto {
    private final Long id;
    private final String path;
    private final Users users;

    public ImageResponseDto(Image entity) {
        this.id = entity.getId();
        this.path = entity.getPath();
        this.users = entity.getUsers();
    }
}
