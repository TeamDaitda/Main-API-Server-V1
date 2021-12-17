package com.daitda.backend.file.controller;

import com.daitda.backend.file.service.FileUploadService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/upload")
public class FileUploadController {
    private final FileUploadService fileUploadService;

    @ApiOperation(value = "이미지 업로드", notes = "이미지 파일을 받아 원격 저장소에 이미지를 업로드 합니다.")
    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public String uploadImage(@RequestPart MultipartFile file) {
        return fileUploadService.uploadImage(file);
    }
}
