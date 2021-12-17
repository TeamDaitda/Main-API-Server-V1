package com.daitda.backend.image.dto;

import com.daitda.backend.image.domain.Image;
import com.daitda.backend.user.domain.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ImageSaveRequestDto {
    private String path;
    private Long userId;

    @Builder
    ImageSaveRequestDto(String path, Long userId) {
        this.path = path;
        this.userId = userId;
    }
}
