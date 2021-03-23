package com.daitda.backend.dto.adLogs;

import com.daitda.backend.domain.adLogs.AdLogs;
import com.daitda.backend.domain.ads.Ads;
import com.daitda.backend.domain.users.Users;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AdLogsListResponseDto {
    private Long id;
    private Users users;
    private Ads ads;

    public AdLogsListResponseDto(AdLogs entity) {
        this.id = entity.getId();
        this.users = entity.getUsers();
        this.ads = entity.getAds();
    }
}
