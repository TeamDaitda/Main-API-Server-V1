package com.daitda.backend.advertisement.dto;

import com.daitda.backend.advertisement.domain.Ads;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
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
