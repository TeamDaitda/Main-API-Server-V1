package com.daitda.backend.controller;

import com.daitda.backend.dto.users.UsersListResponseDto;
import com.daitda.backend.dto.users.UsersResponseDto;
import com.daitda.backend.dto.users.UsersSaveRequestDto;
import com.daitda.backend.dto.users.UsersUpdateRequestDto;
import com.daitda.backend.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("")
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

    @GetMapping("/{id}")
    public UsersResponseDto findById(@PathVariable Long id) {
        return usersService.findById(id);
    }
}
