package com.daitda.backend.user.dto;

import com.daitda.backend.user.domain.Users;
import lombok.Getter;

@Getter
public class UsersResponseDto {
    private final Long id;
    private final String name;
    private final String affiliation;
    private final String phone;
    private final int category;

    public UsersResponseDto(Users entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.affiliation = entity.getAffiliation();
        this.phone = entity.getPhone();
        this.category = entity.getCategory();
    }
}
