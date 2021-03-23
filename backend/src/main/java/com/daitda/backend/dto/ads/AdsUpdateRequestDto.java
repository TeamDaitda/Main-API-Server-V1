package com.daitda.backend.dto.ads;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AdsUpdateRequestDto {

    private Long userId;
    private Long adId;

    @Builder
    public AdsUpdateRequestDto(Long userId, Long adId) {
        this.userId = userId;
        this.adId = adId;
    }
}
