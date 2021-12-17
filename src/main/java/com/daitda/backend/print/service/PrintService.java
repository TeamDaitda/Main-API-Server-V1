package com.daitda.backend.print.service;

import com.daitda.backend.print.domain.Print;
import com.daitda.backend.print.domain.PrintRepository;
import com.daitda.backend.print.dto.PrintListResponseDto;
import com.daitda.backend.print.dto.PrintResponseDto;
import com.daitda.backend.print.dto.PrintSaveRequestDto;
import com.daitda.backend.user.domain.Users;
import com.daitda.backend.user.domain.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PrintService {
    private final UsersRepository usersRepository;
    private final PrintRepository printRepository;

    @Transactional
    public Long save(PrintSaveRequestDto requestDto) {
        Users users = usersRepository
                .findById(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + requestDto.getUserId()));
        Print print = new Print(users, requestDto.getPath());
        printRepository.save(print);
        return print.getId();
    }

    @Transactional
    public PrintResponseDto findByUsersId(Long id) {
        Print entity = printRepository
                .findByUsersId(id);
        return new PrintResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PrintListResponseDto> findAllDesc() {
        return printRepository.findAllDesc().stream()
                .map(PrintListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        printRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 프린트 정보가 없습니다. id = " + id));
        printRepository.deleteById(id);
    }
}
