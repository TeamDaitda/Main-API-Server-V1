package com.daitda.backend.service;

import com.daitda.backend.domain.ads.Ads;
import com.daitda.backend.domain.ads.AdsRepository;
import com.daitda.backend.dto.ads.AdsListResponseDto;
import com.daitda.backend.dto.ads.AdsResponseDto;
import com.daitda.backend.dto.ads.AdsSaveRequestDto;
import com.daitda.backend.dto.ads.AdsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class AdsService {
    private final AdsRepository adsRepository;

    @Transactional
    public Long save(AdsSaveRequestDto requestDto) {
        return adsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id) {
        Ads ads = adsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 광고가 없습니다. id = " + id));
        ads.updateViews();
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Ads ads = adsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 광고가 없습니다. id = " + id));
        adsRepository.delete(ads);
    }

    @Transactional
    public AdsResponseDto findById(Long id) {
        Ads entity = adsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 광고가 없습니다. id = " + id));
        return new AdsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<AdsListResponseDto> findAllDesc() {
        return adsRepository.findAllDesc().stream()
                .map(AdsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
