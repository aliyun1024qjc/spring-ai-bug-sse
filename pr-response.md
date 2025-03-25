@tzolov Thank you for your feedback! I've created a sample project to demonstrate the issue:

**Repository**: https://github.com/aliyun1024qjc/spring-ai-bug

## Issue Demonstration

The repository contains a minimal setup that clearly shows both auto-configurations are activated simultaneously in certain scenarios, leading to duplicate SSE connections and tool registrations.

### Key Findings

1. Both transport implementations (`SseHttpClientTransportAutoConfiguration` and `SseWebFluxTransportAutoConfiguration`) are activated when the WebFlux dependency is present
2. This occurs regardless of the `type` setting (SYNC or ASYNC)

### Evidence

#### Scenario 1: SYNC Mode
- When `type: SYNC` is configured, the application fails to start
- Error: `Multiple tools with the same name (get_addr_date)`
- Logs show two client connections being created:
  - `[ient-1-Worker-2]` 
  - `[ient-2-Worker-0]`

#### Scenario 2: ASYNC Mode
- When `type: ASYNC` is configured, the application starts
- But accessing `/getServerList` endpoint shows duplicate tools
- Logs confirm two separate connections:
  ```
  工具名称: get_addr_date, 描述: 获取指定地点的当前时间
  工具名称: get_addr_date, 描述: 获取指定地点的当前时间
  ```

### Root Cause

The issue is in `McpClientAutoConfiguration` which doesn't ensure mutually exclusive activation of transport implementations:

```java
@AutoConfiguration(after = { 
    StdioTransportAutoConfiguration.class, 
    SseHttpClientTransportAutoConfiguration.class,
    SseWebFluxTransportAutoConfiguration.class 
})
```

## How to Reproduce

1. Clone the repository: `git clone https://github.com/aliyun1024qjc/spring-ai-bug`
2. Open in your IDE
3. Run the client application with different configurations:
   - Change `type: SYNC` in application.yml to see startup failure
   - Use `type: ASYNC` and access `/getServerList` to see duplicate tools

My PR adds explicit transport mode configuration (`spring.ai.mcp.client.sse.transport-mode`) to ensure only one implementation is active at a time, preventing these issues.

Would you like me to provide any additional information? 