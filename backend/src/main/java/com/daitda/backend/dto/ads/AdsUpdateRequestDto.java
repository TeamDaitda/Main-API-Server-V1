package com.daitda.backend.dto.ads;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AdsUpdateRequestDto {
    private int view;

    @Builder
    public AdsUpdateRequestDto() {
        view++;
    }
}
