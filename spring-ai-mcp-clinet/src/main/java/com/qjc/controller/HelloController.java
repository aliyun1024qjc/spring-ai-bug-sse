package com.qjc.controller;

import io.modelcontextprotocol.client.McpAsyncClient;
import io.modelcontextprotocol.spec.McpSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.model.function.FunctionCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/***
 * @projectName spring-ai-bug
 * @packageName com.qjc.controller
 * @author qjc
 * @description TODO
 * @Email qjc1024@aliyun.com
 * @date 2025-03-25 16:37
 **/
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private ToolCallbackProvider toolCallbackProvider;


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/getServerList")
    public String getServerList(){

        log.info("已注册的工具回调：");
        FunctionCallback[] toolCallbacks = toolCallbackProvider.getToolCallbacks();
        if (toolCallbacks == null || toolCallbacks.length == 0) {
            log.warn("没有找到已注册的工具回调！");
        } else {
            for (FunctionCallback toolCallback : toolCallbacks) {
                log.info("工具名称: {}, 描述: {}", toolCallback.getName(), toolCallback.getDescription());
            }
        }

        return "ok";
    }
}
