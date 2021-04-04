package com.daitda.backend.result.controller;

import com.daitda.backend.result.dto.ResultListResponseDto;
import com.daitda.backend.result.dto.ResultResponseDto;
import com.daitda.backend.result.dto.ResultSaveRequestDto;
import com.daitda.backend.result.service.ResultService;
import com.daitda.backend.user.dto.UsersResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/result")
public class ResultController {
    private final ResultService resultService;

    @ApiOperation(value = "기부 결과 리스트 출력", notes = "모든 사용자의 기부 결과를 출력합니다.")
    @GetMapping(value = "", produces = "application/json; charset=utf8")
    @ResponseStatus(HttpStatus.OK)
    public List<ResultListResponseDto> index() {
        return resultService.findAllDesc();
    }

    @ApiOperation(value = "기부 결과 등록", notes = "사용자의 기부 결과를 등록합니다.")
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Long save(@PathVariable Long id) {
        return resultService.save(id);
    }

    @ApiOperation(value = "기부 결과를 사용자 아이디로 찾기", notes = "기부 결과를 사용자의 아이디로 찾아 사용자의 정보를 반환합니다.")
    @GetMapping(value = "/{id}", produces = "application/json; charset=utf8")
    @ResponseStatus(HttpStatus.OK)
    public ResultResponseDto findByUserId(@PathVariable Long id) {
        return resultService.findByUsersId(id);
    }
}