package com.daitda.backend.result.service;

import com.daitda.backend.image.domain.Image;
import com.daitda.backend.image.domain.ImageRepository;
import com.daitda.backend.result.domain.Result;
import com.daitda.backend.result.domain.ResultRepository;
import com.daitda.backend.result.dto.ResultListResponseDto;
import com.daitda.backend.result.dto.ResultSaveRequestDto;
import com.daitda.backend.user.domain.Users;
import com.daitda.backend.user.domain.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ResultService {
    private final UsersRepository usersRepository;
    private final ImageRepository imageRepository;
    private final ResultRepository resultRepository;

    @Transactional
    public Long save(ResultSaveRequestDto requestDto) {
        Users users = usersRepository
                .findById(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + requestDto.getUserId()));
        Image image = imageRepository
                .findByUsersId(requestDto.getUserId());
        Result result = new Result(users, image);
        resultRepository.save(result);
        return result.getId();
    }

    @Transactional(readOnly = true)
    public List<ResultListResponseDto> findAllDesc() {
        return resultRepository.findAllDesc().stream()
                .map(ResultListResponseDto::new)
                .collect(Collectors.toList());
    }
}
