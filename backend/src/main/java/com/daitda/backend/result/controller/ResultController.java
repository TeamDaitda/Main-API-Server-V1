package com.daitda.backend.result.controller;

import com.daitda.backend.result.dto.ResultListResponseDto;
import com.daitda.backend.result.dto.ResultSaveRequestDto;
import com.daitda.backend.result.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("result")
public class ResultController {
    private final ResultService resultService;

    @PostMapping("")
    public Long save(@RequestBody ResultSaveRequestDto requestDto) {
        return resultService.save(requestDto);
    }

    @GetMapping(value = "", produces = "application/json; charset=utf8")
    public List<ResultListResponseDto> index() {
        return resultService.findAllDesc();
    }
}
