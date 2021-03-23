package com.daitda.backend.service;

import com.daitda.backend.domain.users.Users;
import com.daitda.backend.domain.users.UsersRepository;
import com.daitda.backend.dto.users.UsersListResponseDto;
import com.daitda.backend.dto.users.UsersResponseDto;
import com.daitda.backend.dto.users.UsersSaveRequestDto;
import com.daitda.backend.dto.users.UsersUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Transactional
    public Long save(UsersSaveRequestDto requestDto) {
        return usersRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, UsersUpdateRequestDto requestDto) {
        Users users = usersRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        users.updateCategory(requestDto.getCategory());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Users users = usersRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        usersRepository.delete(users);
    }

    @Transactional
    public UsersResponseDto findById(Long id) {
        Users entity = usersRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return new UsersResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<UsersListResponseDto> findAllDesc() {
        return usersRepository.findAllDesc().stream()
                .map(UsersListResponseDto::new)
                .collect(Collectors.toList());
    }

}
