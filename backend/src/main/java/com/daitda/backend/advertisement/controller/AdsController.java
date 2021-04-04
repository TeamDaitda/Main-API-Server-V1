package com.daitda.backend.advertisement.controller;

import com.daitda.backend.advertisement.service.AdsService;
import com.daitda.backend.advertisement_log.dto.AdLogsListResponseDto;
import com.daitda.backend.advertisement.dto.AdsListResponseDto;
import com.daitda.backend.advertisement.dto.AdsResponseDto;
import com.daitda.backend.advertisement.dto.AdsSaveRequestDto;
import com.daitda.backend.advertisement.dto.AdsUpdateRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ad")
public class AdsController {

    private final AdsService adsService;

    @ApiOperation(value = "광고 정보 리스트 출력", notes = "모든 광고의 정보 리스트를 출력합니다.")
    @GetMapping(value = "", produces = "application/json; charset=utf8")
    @ResponseStatus(HttpStatus.OK)
    public List<AdsListResponseDto> index() {
        return adsService.findAllDesc();
    }

    @ApiOperation(value = "광고 등록", notes = "신규 광고를 등록합니다.")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Long save(@RequestBody AdsSaveRequestDto requestDto) {
        return adsService.save(requestDto);
    }

    @ApiOperation(value = "광고 삭제", notes = "광고의 정보를 삭제합니다.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long delete(@PathVariable Long id) {
        adsService.delete(id);
        return id;
    }

    @ApiOperation(value = "광고 아이디로 광고 정보 찾기", notes = "광고 아이디로 광고의 정보를 검색해 반환합니다.")
    @GetMapping(value = "/{id}", produces = "application/json; charset=utf8")
    @ResponseStatus(HttpStatus.OK)
    public AdsResponseDto findById(@PathVariable Long id) {
        return adsService.findById(id);
    }

    @ApiOperation(value = "광고 조회수 처리", notes = "광고의 아이디를 입력받아 광고 조회수 처리를 합니다.")
    @PutMapping("/view")
    @ResponseStatus(HttpStatus.OK)
    public Long update(@RequestBody AdsUpdateRequestDto requestDto) {
        return adsService.update(requestDto);
    }

    @ApiOperation(value = "광고 로그 출력", notes = "모든 광고의 로그를 출력합니다")
    @GetMapping(value = "/log", produces = "application/json; charset=utf8")
    @ResponseStatus(HttpStatus.OK)
    public List<AdLogsListResponseDto> logsIndex() {
        return adsService.findLogsAllDesc();
    }

    @ApiOperation(value = "광고 아이디로 광고 로그 출력", notes = "광고의 아이디로 검색한 광고의 로그를 출력합니다.")
    @GetMapping(value = "/log/{id}", produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public List<AdLogsListResponseDto> logsOneIndex(@PathVariable Long id) {
        return adsService.findLogsByLogsId(id);
    }
}
