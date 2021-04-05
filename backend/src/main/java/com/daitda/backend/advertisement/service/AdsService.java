package com.daitda.backend.advertisement.service;

import com.daitda.backend.advertisement.dto.*;
import com.daitda.backend.advertisement_log.domain.AdLogs;
import com.daitda.backend.advertisement_log.domain.AdLogsRepository;
import com.daitda.backend.advertisement.domain.Ads;
import com.daitda.backend.advertisement.domain.AdsRepository;
import com.daitda.backend.advertisement_log.dto.AdLogsDto;
import com.daitda.backend.user.domain.Users;
import com.daitda.backend.user.domain.UsersRepository;
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
    public Long save(AdsDto.SaveRequest requestDto) {
        return adsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(AdsDto.UpdateRequest requestDto) {
        Users users = usersRepository.findById(requestDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + requestDto.getUserId()));
        Ads ads = adsRepository.findById(requestDto.getAdId()).orElseThrow(() -> new IllegalArgumentException("해당 광고가 없습니다. id = " + requestDto.getAdId()));
        AdLogs adLogs = new AdLogs(users, ads);
        adLogsRepository.save(adLogs);
        ads.updateViews();
        return adLogs.getId();
    }

    @Transactional
    public void delete(Long id) {
        Ads ads = adsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 광고가 없습니다. id = " + id));
        adsRepository.delete(ads);
    }

    @Transactional
    public AdsDto.Response findById(Long id) {
        Ads entity = adsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 광고가 없습니다. id = " + id));
        return new AdsDto.Response(entity);
    }

    @Transactional(readOnly = true)
    public List<AdsDto.ListResponse> findAllDesc() {
        return adsRepository.findAllDesc().stream()
                .map(AdsDto.ListResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<AdLogsDto.ListResponse> findLogsAllDesc() {
        return adLogsRepository.findAllDesc().stream()
                .map(AdLogsDto.ListResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<AdLogsDto.ListResponse> findLogsByLogsId(Long id) {
        return adLogsRepository.findByAdsId(id).stream()
                .map(AdLogsDto.ListResponse::new)
                .collect(Collectors.toList());
    }
}
