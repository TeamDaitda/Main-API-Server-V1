package com.daitda.backend.result.controller;

import com.daitda.backend.result.dto.ResultResponseDto;
import com.daitda.backend.result.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("result/view")
public class ResultWebController {
    private final ResultService resultService;

    @GetMapping("/{id}")
    public String findByUserId(@PathVariable Long id, Model model) {
        ResultResponseDto dto = resultService.findByUsersId(id);
        model.addAttribute("result", dto);
        return "index";
    }
}
