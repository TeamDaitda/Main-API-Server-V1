package com.daitda.backend.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersUpdateRequestDto {
    private int category;

    @Builder
    public UsersUpdateRequestDto(int category) {
        this.category = category;
    }
}
