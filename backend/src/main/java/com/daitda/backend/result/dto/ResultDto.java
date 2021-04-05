package com.daitda.backend.result.dto;

import com.daitda.backend.result.domain.Result;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;

public class ResultDto {
    @Getter
    public static class SaveRequest {
        private final Long userId;

        @Builder
        public SaveRequest(Long userId) {
            this.userId = userId;
        }
    }

    @Getter
    public static class Response {
        private final Long userId;
        private final String name;
        private final String phone;
        private final int category;
        private final String path;

        public Response(Result entity) {
            this.userId = entity.getUsers().getId();
            this.name = entity.getUsers().getName();
            this.phone = entity.getUsers().getPhone();
            this.category = entity.getUsers().getCategory();
            this.path = entity.getImage().getPath();
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class ListResponse {
        private Long id;
        private Long userId;
        private String name;
        private String phone;
        private int category;
        private String path;

        public ListResponse(Result entity) {
            this.id = entity.getId();
            this.userId = entity.getUsers().getId();
            this.name = entity.getUsers().getName();
            this.phone = entity.getUsers().getPhone();
            this.category = entity.getUsers().getCategory();
            this.path = entity.getImage().getPath();
        }
    }
}
