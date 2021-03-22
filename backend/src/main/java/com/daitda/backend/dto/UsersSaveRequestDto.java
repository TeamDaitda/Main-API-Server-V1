package com.daitda.backend.dto;

import com.daitda.backend.domain.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {
    private String name;
    private String affiliation;
    private String phone;
    private int category;

    @Builder
    UsersSaveRequestDto(String name, String affiliation, String phone, int category) {
        this.name = name;
        this.affiliation = affiliation;
        this.phone = phone;
        this.category = category;
    }

    public Users toEntity(){
        return Users.builder()
                .name(name)
                .affiliation(affiliation)
                .phone(phone)
                .category(category)
                .build();
    }
}
