package com.daitda.backend.controller;

import com.daitda.backend.dto.UsersListResponseDto;
import com.daitda.backend.dto.UsersResponseDto;
import com.daitda.backend.dto.UsersSaveRequestDto;
import com.daitda.backend.dto.UsersUpdateRequestDto;
import com.daitda.backend.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private UsersService usersService;

//    @TokenRequired

    @GetMapping("")
    public List<UsersListResponseDto> index() {
        return usersService.findAllDesc();
    }

    @PostMapping("")
    public long save(@RequestBody UsersSaveRequestDto requestDto) {
        return usersService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody UsersUpdateRequestDto requestDto) {
        return usersService.update(id, requestDto);
    }

    @DeleteMapping("{id}")
    public Long delete(@PathVariable Long id) {
        usersService.delete(id);
        return id;
    }

    @GetMapping("/{id}")
    public UsersResponseDto findById(@PathVariable Long id) {
        return usersService.findById(id);
    }
}
