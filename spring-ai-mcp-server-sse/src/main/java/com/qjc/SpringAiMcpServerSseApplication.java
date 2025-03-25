package com.qjc;

import com.qjc.service.DateService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiMcpServerSseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiMcpServerSseApplication.class, args);
    }


    @Bean
    public ToolCallbackProvider dateTools(DateService dateService) {
        return MethodToolCallbackProvider.builder().toolObjects(dateService).build();
    }

}
