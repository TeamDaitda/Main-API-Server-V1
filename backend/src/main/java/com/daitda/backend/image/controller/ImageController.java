package com.daitda.backend.image.controller;

import com.daitda.backend.image.domain.Image;
import com.daitda.backend.image.dto.ImageDto;
import com.daitda.backend.image.service.ImageService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/image")
public class ImageController {
    private final ImageService imageService;

    @ApiOperation(value = "저장된 이미지 리스트 출력", notes = "저장된 모든 이미지의 정보 리스트를 출력합니다.")
    @GetMapping(value = "", produces = "application/json; charset=utf8")
    @ResponseStatus(HttpStatus.OK)
    public List<ImageDto.ListResponse> index() {
        return imageService.findAllDesc();
    }

    @ApiOperation(value = "이미지 저장 정보 저장", notes = "사용자의 이름과 저장된 이미지의 주소로 이미지를 저장합니다.")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Long save(@RequestBody ImageDto.SaveRequest requestDto) {
        return imageService.save(requestDto);
    }

    @ApiOperation(value = "이미지 저장 정보 삭제", notes = "사용자의 이름으로 저장된 이미지의 정보를 삭제합니다.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long delete(@PathVariable Long id) {
        imageService.delete(id);
        return id;
    }

    @ApiOperation(value = "이미지 아이디로 이미지 정보 찾기", notes = "사용자의 아이디로 저장된 이미지의 정보를 찾습니다.")
    @GetMapping(value = "/{id}", produces = "application/json; charset=utf8")
    @ResponseStatus(HttpStatus.OK)
    public ImageDto.Response findById(@PathVariable Long id) {
        return imageService.findById(id);
    }

    @ApiOperation(value = "사용자 아이디로 이미지 정보찾기", notes = "사용자의 아이디로 이미지를 검색해 정보를 반환합니다.")
    @GetMapping(value = "/userId/{id}", produces = "application/json; charset=utf8")
    @ResponseStatus(HttpStatus.OK)
    public Image findByUserId(@PathVariable Long id) {
        return imageService.findByUserId(id);
    }

}
