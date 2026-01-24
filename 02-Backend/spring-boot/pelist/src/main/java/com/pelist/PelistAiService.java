package com.pelist;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService()
public interface PelistAiService {
    @UserMessage("""
            Genera un saludo de bienvenida a los usuarios a nuestra plataforma de peliculas llamada {{platform}},
            debe ser un saludo amable y calido; Usa menos de 120 caracteres.
            """)
    String generateGreeting(@V("platform") String platform);
}
