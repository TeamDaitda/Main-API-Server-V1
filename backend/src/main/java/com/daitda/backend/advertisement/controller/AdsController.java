package com.daitda.backend.advertisement.controller;

import com.daitda.backend.advertisement.service.AdsService;
import com.daitda.backend.advertisement_log.dto.AdLogsListResponseDto;
import com.daitda.backend.advertisement.dto.AdsListResponseDto;
import com.daitda.backend.advertisement.dto.AdsResponseDto;
import com.daitda.backend.advertisement.dto.AdsSaveRequestDto;
import com.daitda.backend.advertisement.dto.AdsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ad")
public class AdsController {

    private final AdsService adsService;

    @GetMapping(value = "", produces = "application/json; charset=utf8")
    public List<AdsListResponseDto> index() {
        return adsService.findAllDesc();
    }

    @PostMapping("")
    public Long save(@RequestBody AdsSaveRequestDto requestDto) {
        return adsService.save(requestDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        adsService.delete(id);
        return id;
    }

    @GetMapping(value = "/{id}", produces = "application/json; charset=utf8")
    public AdsResponseDto findById(@PathVariable Long id) {
        return adsService.findById(id);
    }

    @PutMapping("/view")
    public Long update(@RequestBody AdsUpdateRequestDto requestDto) {
        return adsService.update(requestDto);
    }

    @GetMapping(value = "/log", produces = "application/json; charset=utf8")
    public List<AdLogsListResponseDto> logsIndex() {
        return adsService.findLogsAllDesc();
    }

    @GetMapping(value = "/log/{id}", produces = "application/json; charset=utf-8")
    public List<AdLogsListResponseDto> logsOneIndex(@PathVariable Long id) {
        return adsService.findLogsByLogsId(id);
    }
}
