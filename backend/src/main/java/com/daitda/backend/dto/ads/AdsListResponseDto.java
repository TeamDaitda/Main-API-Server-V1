package com.daitda.backend.dto.ads;

import com.daitda.backend.domain.ads.Ads;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AdsListResponseDto {
    private Long id;
    private String title;
    private String agency;
    private int view;

    public AdsListResponseDto(Ads entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.agency = entity.getAgency();
        this.view = entity.getView();
    }


}
