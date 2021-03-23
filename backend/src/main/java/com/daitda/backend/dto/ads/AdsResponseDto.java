package com.daitda.backend.dto.ads;

import com.daitda.backend.domain.ads.Ads;
import lombok.Getter;

@Getter
public class AdsResponseDto {
    private Long id;
    private String title;
    private String agency;
    private int view;

    public AdsResponseDto(Ads entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.agency = entity.getAgency();
        this.view = entity.getView();
    }
}
