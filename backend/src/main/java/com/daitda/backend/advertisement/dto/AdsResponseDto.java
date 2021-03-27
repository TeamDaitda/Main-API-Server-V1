package com.daitda.backend.advertisement.dto;

import com.daitda.backend.advertisement.domain.Ads;
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
