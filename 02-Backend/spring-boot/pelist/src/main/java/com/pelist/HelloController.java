package com.pelist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final PelistAiService aiService;

    public HelloController(PelistAiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/")
    public String hello(){
        return this.aiService.generateGreeting();
    }
}
