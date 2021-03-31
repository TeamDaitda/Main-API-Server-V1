package com.daitda.backend.user.controller;

import com.daitda.backend.user.dto.UsersListResponseDto;
import com.daitda.backend.user.dto.UsersResponseDto;
import com.daitda.backend.user.dto.UsersSaveRequestDto;
import com.daitda.backend.user.dto.UsersUpdateRequestDto;
import com.daitda.backend.user.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {

    private final UsersService usersService;

    /*
    * 기능명: 사용자 정보 리스트 출력
    * 설명: 모든 사용자의 정보 리스트를 출력합니다.
    * */
    @GetMapping(value = "", produces = "application/json; charset=utf8")
    public List<UsersListResponseDto> index() {
        return usersService.findAllDesc();
    }

    /*
    * 기능명: 사용자 등록
    * 설명: 사용자의 정보를 저장합니다.
    * */
    @PostMapping("")
    public Long save(@RequestBody UsersSaveRequestDto requestDto) {
        return usersService.save(requestDto);
    }

    /*
    * 기능명: 사용자 기부 카테고리 변경
    * 설명: 사용자의 기부 카테고리를 변경합니다.
    * */
    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody UsersUpdateRequestDto requestDto) {
        return usersService.update(id, requestDto);
    }

    /*
    * 기능명: 사용자 삭제
    * 설명: 사용자의 정보를 삭제합니다.
    * */
    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        usersService.delete(id);
        return id;
    }

    /*
    * 기능명: 사용자 아이디로 정보 찾기
    * 설명: 사용자의 아이디로 사용자의 정보를 찾습니다.
    * */
    @GetMapping(value = "/{id}", produces = "application/json; charset=utf8")
    public UsersResponseDto findById(@PathVariable Long id) {
        return usersService.findById(id);
    }

    /*
    * 기능명: 사용자 이름으로 정보 찾기
    * 설명: 사용자의 이름으로 사용자의 정보를 찾습니다.
    * */
    @GetMapping(value = "/name/{name}", produces = "application/json; charset=utf8")
    public List<UsersListResponseDto> findByName(@PathVariable String name) {
        return usersService.findByName(name);
    }
}
