package com.daitda.backend.image.controller;

import com.daitda.backend.file.service.FileUploadService;
import com.daitda.backend.image.dto.ImageListResponseDto;
import com.daitda.backend.image.dto.ImageResponseDto;
import com.daitda.backend.image.dto.ImageSaveRequestDto;
import com.daitda.backend.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/image")
public class ImageController {
    private final ImageService imageService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<ImageListResponseDto> index() {
        return imageService.findAllDesc();
    }

    @PostMapping("")
    public Long save(@RequestBody ImageSaveRequestDto requestDto) {
        return imageService.save(requestDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        imageService.delete(id);
        return id;
    }

    @GetMapping("/{id}")
    public ImageResponseDto findById(@PathVariable Long id) {
        return imageService.findById(id);
    }
}
