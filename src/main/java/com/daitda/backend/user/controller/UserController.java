package com.daitda.backend.user.controller;

import com.daitda.backend.user.dto.UsersListResponseDto;
import com.daitda.backend.user.dto.UsersResponseDto;
import com.daitda.backend.user.dto.UsersSaveRequestDto;
import com.daitda.backend.user.dto.UsersUpdateRequestDto;
import com.daitda.backend.user.service.UsersService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UsersService usersService;

    @ApiOperation(value = "사용자 정보 리스트 출력", notes = "모든 사용자의 정보 리스트를 출력합니다.")
    @GetMapping(value = "", produces = "application/json; charset=utf8")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, List<UsersListResponseDto>> index() {
        Map<String, List<UsersListResponseDto>> result = new HashMap<>();
        result.put("result", usersService.findAllDesc());
        return result;
    }

    @ApiOperation(value = "사용자 등록", notes = "사용자의 정보를 저장합니다.")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Long save(@RequestBody UsersSaveRequestDto requestDto) {
        return usersService.save(requestDto);
    }

    @ApiOperation(value = "사용자 기부 카테고리 변경", notes = "사용자의 기부 카테고리를 변경합니다.")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long update(@PathVariable Long id, @RequestBody UsersUpdateRequestDto requestDto) {
        return usersService.update(id, requestDto);
    }

    @ApiOperation(value = "사용자 삭제", notes = "사용자의 정보를 삭제합니다.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long delete(@PathVariable Long id) {
        usersService.delete(id);
        return id;
    }

    @ApiOperation(value = "사용자 아이디로 사용자 정보 찾기", notes = "사용자의 아이디로 사용자의 정보를 찾습니다.")
    @GetMapping(value = "/{id}", produces = "application/json; charset=utf8")
    @ResponseStatus(HttpStatus.OK)
    public UsersResponseDto findById(@PathVariable Long id) {
        return usersService.findById(id);
    }

    @ApiOperation(value = "사용자 이름으로 사용자 정보 찾기", notes = "사용자의 이름으로 사용자의 정보를 찾습니다.")
    @GetMapping(value = "/name/{name}", produces = "application/json; charset=utf8")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, List<UsersListResponseDto>> findByName(@PathVariable String name) {
        Map<String, List<UsersListResponseDto>> result = new HashMap<>();
        result.put("result", usersService.findByName(name));
        return result;
    }
}
