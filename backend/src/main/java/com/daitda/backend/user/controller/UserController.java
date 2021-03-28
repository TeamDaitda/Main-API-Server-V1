package com.daitda.backend.user.controller;

import com.daitda.backend.user.dto.UsersListResponseDto;
import com.daitda.backend.user.dto.UsersResponseDto;
import com.daitda.backend.user.dto.UsersSaveRequestDto;
import com.daitda.backend.user.dto.UsersUpdateRequestDto;
import com.daitda.backend.user.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UsersService usersService;

    @GetMapping(value = "", produces = "application/json; charset=utf8")
    public List<UsersListResponseDto> index() {
        return usersService.findAllDesc();
    }

    @PostMapping("")
    public Long save(@RequestBody UsersSaveRequestDto requestDto) {
        return usersService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody UsersUpdateRequestDto requestDto) {
        return usersService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        usersService.delete(id);
        return id;
    }

    @GetMapping(value = "/{id}", produces = "application/json; charset=utf8")
    public UsersResponseDto findById(@PathVariable Long id) {
        return usersService.findById(id);
    }

    @GetMapping(value = "/name/{name}", produces = "application/json; charset=utf8")
    public List<UsersListResponseDto> findByName(@PathVariable String name) {
        return usersService.findByName(name);
    }
}
