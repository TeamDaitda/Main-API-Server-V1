package com.daitda.backend.user.dto;

import com.daitda.backend.user.domain.Users;
import lombok.Getter;

@Getter
public class UsersResponseDto {
    private Long id;
    private String name;
    private String affiliation;
    private String phone;
    private int category;

    public UsersResponseDto(Users entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.affiliation = entity.getAffiliation();
        this.phone = entity.getPhone();
        this.category = entity.getCategory();
    }
}
