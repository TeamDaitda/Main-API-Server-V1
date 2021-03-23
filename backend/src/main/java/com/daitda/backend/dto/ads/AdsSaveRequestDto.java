package com.daitda.backend.dto.ads;

import com.daitda.backend.domain.ads.Ads;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AdsSaveRequestDto {
    private String title;
    private String agency;

    @Builder
    AdsSaveRequestDto(String title, String agency) {
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
