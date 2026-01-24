package com.pelist;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final String platform;
    private final PelistAiService aiService;

    public HelloController(@Value("${spring.application.name}") String platform, PelistAiService aiService) {
        this.aiService = aiService;
        this.platform = platform;
    }

    @GetMapping("/")
    public String hello(){
        return this.aiService.generateGreeting(platform);
    }
}
