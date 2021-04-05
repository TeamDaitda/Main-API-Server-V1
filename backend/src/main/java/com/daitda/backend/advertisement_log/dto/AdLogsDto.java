package com.daitda.backend.advertisement_log.dto;

import com.daitda.backend.advertisement_log.domain.AdLogs;
import com.daitda.backend.advertisement.domain.Ads;
import com.daitda.backend.user.domain.Users;
import com.fasterxml.jackson.annotation.JsonAutoDetect;


public class AdLogsDto {
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class ListResponse {
        private Long id;
        private Users users;
        private Ads ads;

        public ListResponse(AdLogs entity) {
            this.id = entity.getId();
            this.users = entity.getUsers();
            this.ads = entity.getAds();
        }
    }
}