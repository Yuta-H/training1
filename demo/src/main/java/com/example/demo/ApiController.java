package com.example.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@EnableAutoConfiguration

public class ApiController {
    @RequestMapping("/api")
    public Map<String, String> api(){
        return Collections.singletonMap("message","成功しました！！！");
    }
}
