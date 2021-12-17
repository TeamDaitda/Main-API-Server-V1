package com.daitda.backend.result.service;

import com.daitda.backend.image.domain.Image;
import com.daitda.backend.image.domain.ImageRepository;
import com.daitda.backend.result.domain.Result;
import com.daitda.backend.result.domain.ResultRepository;
import com.daitda.backend.result.dto.ResultListResponseDto;
import com.daitda.backend.result.dto.ResultResponseDto;
import com.daitda.backend.user.domain.Users;
import com.daitda.backend.user.domain.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ResultService {
    private final UsersRepository usersRepository;
    private final ImageRepository imageRepository;
    private final ResultRepository resultRepository;

    @Transactional
    public Long save(Long id) {
        Users users = usersRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        Image image = imageRepository
                .findByUsersId(id);
        Result result = new Result(users, image);
        resultRepository.save(result);
        return result.getId();
    }

    @Transactional
    public ResultResponseDto findByUsersId(Long id) {
        Result entity = resultRepository.findByUsersId(id);
        return new ResultResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ResultListResponseDto> findAllDesc() {
        return resultRepository.findAllDesc().stream()
                .map(ResultListResponseDto::new)
                .collect(Collectors.toList());
    }
}
