package com.daitda.backend.controller;

import com.daitda.backend.dto.ads.AdsListResponseDto;
import com.daitda.backend.dto.ads.AdsResponseDto;
import com.daitda.backend.dto.ads.AdsSaveRequestDto;
import com.daitda.backend.dto.ads.AdsUpdateRequestDto;
import com.daitda.backend.service.AdsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ads")
public class AdsController {
    @Autowired
    private AdsService adsService;

    @GetMapping("")
    public List<AdsListResponseDto> index() {
        return adsService.findAllDesc();
    }

    @PostMapping("")
    public Long save(@RequestBody AdsSaveRequestDto requestDto) {
        return adsService.save(requestDto);
    }

    // View ++
    @PutMapping("/{id}")
    public Long update(@PathVariable Long id) {
        return adsService.update(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        adsService.delete(id);
        return id;
    }

    @GetMapping("/{id}")
    public AdsResponseDto findById(@PathVariable Long id) {
        return adsService.findById(id);
    }
}
