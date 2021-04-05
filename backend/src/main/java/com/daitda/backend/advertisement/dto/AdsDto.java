package com.daitda.backend.advertisement.dto;

import com.daitda.backend.advertisement.domain.Ads;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AdsDto {
    @Getter
    @NoArgsConstructor
    public static class SaveRequest {
        private String title;
        private String agency;

        @Builder
        SaveRequest(String title, String agency) {
            this.title = title;
            this.agency = agency;
        }

        public Ads toEntity() {
            return Ads.builder()
                    .title(title)
                    .agency(agency)
                    .build();
        }
    }

    @Getter
    public static class Response {
        private final Long id;
        private final String title;
        private final String agency;
        private final int view;

        public Response(Ads entity) {
            this.id = entity.getId();
            this.title = entity.getTitle();
            this.agency = entity.getAgency();
            this.view = entity.getView();
        }
    }

    @Getter
    public static class UpdateRequest {
        private final Long userId;
        private final Long adId;

        @Builder
        public UpdateRequest(Long userId, Long adId) {
            this.userId = userId;
            this.adId = adId;
        }
    }

    @Getter
    @NoArgsConstructor
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class ListResponse {
        private Long id;
        private String title;
        private String agency;
        private int view;

        public ListResponse(Ads entity) {
            this.id = entity.getId();
            this.title = entity.getTitle();
            this.agency = entity.getAgency();
            this.view = entity.getView();
        }
    }
}
