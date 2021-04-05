package com.daitda.backend.user.dto;

import com.daitda.backend.user.domain.Users;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDto {

    @Getter
    public static class Response {
        private final Long id;
        private final String name;
        private final String affiliation;
        private final String phone;
        private final int category;

        public Response(Users entity) {
            this.id = entity.getId();
            this.name = entity.getName();
            this.affiliation = entity.getAffiliation();
            this.phone = entity.getPhone();
            this.category = entity.getCategory();
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class ListResponse {
        private Long id;
        private String name;
        private String affiliation;
        private String phone;
        private int category;

        public ListResponse(Users entity) {
            this.id = entity.getId();
            this.name = entity.getName();
            this.affiliation = entity.getAffiliation();
            this.phone = entity.getPhone();
            this.category = entity.getCategory();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class SaveRequest {
        private String name;
        private String affiliation;
        private String phone;
        private int category;

        @Builder
        SaveRequest(String name, String affiliation, String phone, int category) {
            this.name = name;
            this.affiliation = affiliation;
            this.phone = phone;
            this.category = category;
        }

        public Users toEntity() {
            return Users.builder()
                    .name(name)
                    .affiliation(affiliation)
                    .phone(phone)
                    .category(category)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateRequest {
        private int category;

        @Builder
        public UpdateRequest(int category) {
            this.category = category;
        }
    }
}
