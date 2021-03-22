package com.daitda.backend.dto;

import com.daitda.backend.domain.Users;

public class UsersListResponseDto {
    private Long id;
    private String name;
    private String affiliation;
    private String phone;
    private int category;

    public UsersListResponseDto(Users entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.affiliation = entity.getAffiliation();
        this.phone = entity.getPhone();
        this.category = entity.getCategory();
    }
}
