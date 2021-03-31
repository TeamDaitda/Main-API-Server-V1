package com.daitda.backend.user.service;

import com.daitda.backend.advertisement_log.domain.AdLogs;
import com.daitda.backend.advertisement_log.domain.AdLogsRepository;
import com.daitda.backend.advertisement_log.dto.AdLogsListResponseDto;
import com.daitda.backend.user.domain.Users;
import com.daitda.backend.user.domain.UsersRepository;
import com.daitda.backend.user.dto.UsersListResponseDto;
import com.daitda.backend.user.dto.UsersResponseDto;
import com.daitda.backend.user.dto.UsersSaveRequestDto;
import com.daitda.backend.user.dto.UsersUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final AdLogsRepository adLogsRepository;

    @Transactional
    public Long save(UsersSaveRequestDto requestDto) {
        return usersRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, UsersUpdateRequestDto requestDto) {
        Users users = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        users.updateCategory(requestDto.getCategory());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Users users = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        List<AdLogs> adLogs = adLogsRepository.findByUsersId(id);
        adLogs.forEach(element -> adLogsRepository.deleteById(element.getId()));
        usersRepository.delete(users);
    }

    @Transactional
    public UsersResponseDto findById(Long id) {
        Users entity = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return new UsersResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<UsersListResponseDto> findAllDesc() {
        return usersRepository.findAllDesc().stream()
                .map(UsersListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<UsersListResponseDto> findByName(String name) {
        return usersRepository.findByName(name).stream()
                .map(UsersListResponseDto::new)
                .collect(Collectors.toList());
    }


}
