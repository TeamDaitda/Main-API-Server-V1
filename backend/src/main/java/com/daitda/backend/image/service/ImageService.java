package com.daitda.backend.image.service;

import com.daitda.backend.image.domain.Image;
import com.daitda.backend.image.domain.ImageRepository;
import com.daitda.backend.image.dto.ImageDto;
import com.daitda.backend.user.domain.Users;
import com.daitda.backend.user.domain.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final UsersRepository usersRepository;

    @Transactional
    public Long save(ImageDto.SaveRequest requestDto) {
        Users users = usersRepository.findById(requestDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 Id가 존재하지 않습니다."));
        Image image = new Image(requestDto.getPath(), users);
        imageRepository.save(image);
        return image.getId();
    }

    @Transactional
    public void delete(Long id) {
        Image image = imageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 Id가 존재하지 않습니다."));
        imageRepository.delete(image);
    }

    @Transactional
    public ImageDto.Response findById(Long id) {
        Image entity = imageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 Id가 존재하지 않습니다."));
        return new ImageDto.Response(entity);
    }

    @Transactional
    public Image findByUserId(Long id) {
        return imageRepository.findByUsersId(id).get(0);
    }

    @Transactional(readOnly = true)
    public List<ImageDto.ListResponse> findAllDesc() {
        return imageRepository.findAllDesc().stream()
                .map(ImageDto.ListResponse::new)
                .collect(Collectors.toList());
    }
}
