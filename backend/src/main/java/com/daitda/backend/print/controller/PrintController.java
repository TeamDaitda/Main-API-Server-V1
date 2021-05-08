package com.daitda.backend.print.controller;

import com.daitda.backend.print.dto.PrintListResponseDto;
import com.daitda.backend.print.dto.PrintResponseDto;
import com.daitda.backend.print.dto.PrintSaveRequestDto;
import com.daitda.backend.print.service.PrintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/print")
public class PrintController {
    private final PrintService printService;

    @GetMapping(value = "/{id}", produces = "application/json; charset=utf8")
    @ResponseStatus(HttpStatus.OK)
    public PrintResponseDto findByUserId(@PathVariable Long id) {
        return printService.findByUsersId(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Long save(@RequestBody PrintSaveRequestDto requestDto) {
        return printService.save(requestDto);
    }

    @GetMapping(value = "", produces = "application/json; charset=utf8")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, List<PrintListResponseDto>> index() {
        Map<String, List<PrintListResponseDto>> result = new HashMap<>();
        result.put("result", printService.findAllDesc());
        return result;
    }

    @DeleteMapping(value = "/{id}", produces = "application/json; charset=utf8")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> delete(@PathVariable Long id) {
        printService.delete(id);
        Map<String, String> result = new HashMap<>();
        result.put("result", "OK");
        return result;
    }
}
