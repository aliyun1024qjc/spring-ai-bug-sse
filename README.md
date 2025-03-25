# Spring AI MCP Client Duplicate Tools Issue Demonstration

This repository demonstrates the issue with duplicate SSE connections and MCP tools creation in Spring AI when both WebFlux and HTTP Client implementations are available.

## Issue Description

When both WebFlux and HTTP Client transport implementations are available, the following issues occur:

1. **Duplicate SSE Connections Problem**
   - `McpClientAutoConfiguration` loads both implementations
   - `SseWebFluxTransportAutoConfiguration` and `SseHttpClientTransportAutoConfiguration` create duplicate connections
   - Results in unnecessary resource consumption and potential performance issues

2. **Duplicate MCP Tools Creation**
   - Multiple identical MCP tools are created due to duplicate transport implementations
   - This affects system efficiency and resource utilization
   - May cause confusion in tool management and callbacks

## How to Reproduce

This repository contains a minimal project that reproduces the issue:

### Scenario 1: SYNC Mode (Application Fails to Start)

1. Open `spring-ai-mcp-clinet/src/main/resources/application.yml`
2. Set `spring.ai.mcp.client.type` to `SYNC`
3. Run the application
4. Observe the error: `Multiple tools with the same name (get_addr_date)`

### Scenario 2: ASYNC Mode (Application Starts but with Duplicate Tools)

1. Open `spring-ai-mcp-clinet/src/main/resources/application.yml`
2. Set `spring.ai.mcp.client.type` to `ASYNC`
3. Run the application
4. Access the endpoint `http://localhost:8080/getServerList`
5. Observe in logs that duplicate tools with the same name are registered

## Dependencies Used

```xml
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-mcp-client-webflux-spring-boot-starter</artifactId>
</dependency>
```

## Current Workarounds

Temporary workarounds (until PR #2493 is merged):

1. Exclude one of the auto-configurations:
   ```properties
   spring.autoconfigure.exclude=org.springframework.ai.autoconfigure.mcp.client.SseHttpClientTransportAutoConfiguration
   ```

2. Or in application class:
   ```java
   @SpringBootApplication(exclude = {
       org.springframework.ai.autoconfigure.mcp.client.SseHttpClientTransportAutoConfiguration.class
   })
   ```

## Proposed Solution

The proposed solution in [PR #2493](https://github.com/spring-projects/spring-ai/pull/2493) adds explicit transport mode configuration:

```properties
spring.ai.mcp.client.sse.transport-mode=WEBFLUX  # or HTTP_CLIENT
```

This ensures only one transport implementation is active at a time. 