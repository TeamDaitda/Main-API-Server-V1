package com.daitda.backend.image.dto;

import com.daitda.backend.image.domain.Image;
import com.daitda.backend.user.domain.Users;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ImageDto {
    @Setter
    @Getter
    @NoArgsConstructor
    public static class SaveRequest {
        private String path;
        private Long userId;

        @Builder
        SaveRequest(String path, Long userId) {
            this.path = path;
            this.userId = userId;
        }
    }

    @Setter
    public static class Response {
        private final Long id;
        private final String path;
        private final Users users;

        public Response(Image entity) {
            this.id = entity.getId();
            this.path = entity.getPath();
            this.users = entity.getUsers();
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class ListResponse {
        private Long id;
        private String path;
        private Users users;

        public ListResponse(Image entity) {
            this.id = entity.getId();
            this.path = entity.getPath();
            this.users = entity.getUsers();
        }
    }
}