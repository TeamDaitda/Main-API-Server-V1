package com.daitda.backend.service;

import com.daitda.backend.domain.adLogs.AdLogs;
import com.daitda.backend.domain.adLogs.AdLogsRepository;
import com.daitda.backend.domain.ads.Ads;
import com.daitda.backend.domain.ads.AdsRepository;
import com.daitda.backend.domain.users.Users;
import com.daitda.backend.domain.users.UsersRepository;
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
    private final UsersRepository usersRepository;
    private final AdsRepository adsRepository;
    private final AdLogsRepository adLogsRepository;

    @Transactional
    public Long save(AdsSaveRequestDto requestDto) {
        return adsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(AdsUpdateRequestDto requestDto) {
        Users users = usersRepository.findById(requestDto.getUserId()).orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id = " + requestDto.getUserId()));
        Ads ads = adsRepository.findById(requestDto.getAdId()).orElseThrow(()-> new IllegalArgumentException("해당 광고가 없습니다. id = " + requestDto.getAdId()));
        AdLogs adLogs = new AdLogs(users, ads);
        adLogsRepository.save(adLogs);
        ads.updateViews();
        return adLogs.getId();
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
