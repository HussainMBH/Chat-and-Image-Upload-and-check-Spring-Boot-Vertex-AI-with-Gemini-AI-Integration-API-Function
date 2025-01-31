package com.AIwithJava.AI.Integration.with.Spring.Boot;

import com.google.cloud.vertexai.generativeai.GenerativeModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.cloud.vertexai.VertexAI;

@Configuration(proxyBeanMethods = false)
public class GeminiConfiguration {

    @Bean
    public VertexAI vertexAI() {
        return new VertexAI("sodium-wall-429709-r1", "asia-south1");
    }

    @Bean
    public GenerativeModel generativeModel(VertexAI vertexAI) {
        return new GenerativeModel("gemini-1.5-flash-001", vertexAI);
    }
}
