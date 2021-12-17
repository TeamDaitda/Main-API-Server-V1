package com.daitda.backend.advertisement.dto;

import com.daitda.backend.advertisement.domain.Ads;
import lombok.Getter;

@Getter
public class AdsResponseDto {
    private final Long id;
    private final String title;
    private final String agency;
    private final int view;

    public AdsResponseDto(Ads entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.agency = entity.getAgency();
        this.view = entity.getView();
    }
}
