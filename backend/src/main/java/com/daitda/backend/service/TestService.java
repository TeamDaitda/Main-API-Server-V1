package com.daitda.backend.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {
    public Map<String, String> getTest(){
        Map<String, String> res = new HashMap<>();
        res.put("test", "hihi");

        return res;
    }
}
