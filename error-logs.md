# Error Logs Demonstrating the Issue

## Scenario 1: SYNC Mode (Application Fails to Start)

Configuration:
```yaml
spring:
  ai:
    mcp:
      client:
        type: SYNC
```

Log output:
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.4)

2025-03-25T17:08:10.444+08:00  INFO 11868 --- [ai-mcp-clinet] [           main] com.qjc.SpringAiMcpClinetApplication     : Starting SpringAiMcpClinetApplication using Java 17.0.12 with PID 11868 (C:\Users\capitek-qijch\ai-project\spring-ai-bug\spring-ai-mcp-clinet\target\classes started by capitek-qijch in C:\Users\capitek-qijch\ai-project\spring-ai-bug)
2025-03-25T17:08:10.447+08:00 DEBUG 11868 --- [ai-mcp-clinet] [           main] com.qjc.SpringAiMcpClinetApplication     : Running with Spring Boot v3.4.4, Spring v6.2.5
2025-03-25T17:08:10.448+08:00  INFO 11868 --- [ai-mcp-clinet] [           main] com.qjc.SpringAiMcpClinetApplication     : No active profile set, falling back to 1 default profile: "default"
2025-03-25T17:08:11.654+08:00  INFO 11868 --- [ai-mcp-clinet] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2025-03-25T17:08:11.676+08:00  INFO 11868 --- [ai-mcp-clinet] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-03-25T17:08:11.676+08:00  INFO 11868 --- [ai-mcp-clinet] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.39]
2025-03-25T17:08:11.755+08:00  INFO 11868 --- [ai-mcp-clinet] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-03-25T17:08:11.755+08:00  INFO 11868 --- [ai-mcp-clinet] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1259 ms
2025-03-25T17:08:13.301+08:00  INFO 11868 --- [ai-mcp-clinet] [ient-1-Worker-2] i.m.client.McpAsyncClient                : Server response with Protocol: 2024-11-05, Capabilities: ServerCapabilities[experimental=null, logging=LoggingCapabilities[], prompts=null, resources=null, tools=ToolCapabilities[listChanged=true]], Info: Implementation[name=spring-ai-mcp-server-sse, version=1.0.0] and Instructions null
2025-03-25T17:08:13.368+08:00  WARN 11868 --- [ai-mcp-clinet] [ient-1-Worker-3] i.m.spec.DefaultMcpSession               : Unexpected response for unkown id a43493ee-0
2025-03-25T17:08:13.369+08:00  INFO 11868 --- [ai-mcp-clinet] [ient-2-Worker-0] i.m.client.McpAsyncClient                : Server response with Protocol: 2024-11-05, Capabilities: ServerCapabilities[experimental=null, logging=LoggingCapabilities[], prompts=null, resources=null, tools=ToolCapabilities[listChanged=true]], Info: Implementation[name=spring-ai-mcp-server-sse, version=1.0.0] and Instructions null
2025-03-25T17:08:13.656+08:00  WARN 11868 --- [ai-mcp-clinet] [ient-2-Worker-2] i.m.spec.DefaultMcpSession               : Unexpected response for unkown id be6eb9a7-1
2025-03-25T17:08:13.669+08:00  WARN 11868 --- [ai-mcp-clinet] [ient-1-Worker-3] i.m.spec.DefaultMcpSession               : Unexpected response for unkown id a43493ee-1
2025-03-25T17:08:13.684+08:00  WARN 11868 --- [ai-mcp-clinet] [           main] ConfigServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'toolCallbacksDeprecated' defined in class path resource [org/springframework/ai/autoconfigure/mcp/client/McpClientAutoConfiguration.class]: Failed to instantiate [java.util.List]: Factory method 'toolCallbacksDeprecated' threw exception with message: Multiple tools with the same name (get_addr_date)
2025-03-25T17:08:13.687+08:00  INFO 11868 --- [ai-mcp-clinet] [           main] o.apache.catalina.core.StandardService   : Stopping service [Tomcat]
2025-03-25T17:08:13.706+08:00  INFO 11868 --- [ai-mcp-clinet] [           main] .s.b.a.l.ConditionEvaluationReportLogger : 

Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2025-03-25T17:08:13.724+08:00 ERROR 11868 --- [ai-mcp-clinet] [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'toolCallbacksDeprecated' defined in class path resource [org/springframework/ai/autoconfigure/mcp/client/McpClientAutoConfiguration.class]: Failed to instantiate [java.util.List]: Factory method 'toolCallbacksDeprecated' threw exception with message: Multiple tools with the same name (get_addr_date)
	at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:657) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:645) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1361) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1191) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:563) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:523) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:339) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:347) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:337) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.instantiateSingleton(DefaultListableBeanFactory.java:1155) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingleton(DefaultListableBeanFactory.java:1121) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:1056) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:987) ~[spring-context-6.2.5.jar:6.2.5]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:627) ~[spring-context-6.2.5.jar:6.2.5]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.4.4.jar:3.4.4]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:752) ~[spring-boot-3.4.4.jar:3.4.4]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:439) ~[spring-boot-3.4.4.jar:3.4.4]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:318) ~[spring-boot-3.4.4.jar:3.4.4]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1361) ~[spring-boot-3.4.4.jar:3.4.4]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1350) ~[spring-boot-3.4.4.jar:3.4.4]
	at com.qjc.SpringAiMcpClinetApplication.main(SpringAiMcpClinetApplication.java:10) ~[classes/:na]
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [java.util.List]: Factory method 'toolCallbacksDeprecated' threw exception with message: Multiple tools with the same name (get_addr_date)
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.lambda$instantiate$0(SimpleInstantiationStrategy.java:199) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiateWithFactoryMethod(SimpleInstantiationStrategy.java:88) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:168) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:653) ~[spring-beans-6.2.5.jar:6.2.5]
	... 21 common frames omitted
Caused by: java.lang.IllegalStateException: Multiple tools with the same name (get_addr_date)
	at org.springframework.ai.mcp.SyncMcpToolCallbackProvider.validateToolCallbacks(SyncMcpToolCallbackProvider.java:126) ~[spring-ai-mcp-1.0.0-M6.jar:1.0.0-M6]
	at org.springframework.ai.mcp.SyncMcpToolCallbackProvider.getToolCallbacks(SyncMcpToolCallbackProvider.java:110) ~[spring-ai-mcp-1.0.0-M6.jar:1.0.0-M6]
	at org.springframework.ai.autoconfigure.mcp.client.McpClientAutoConfiguration.toolCallbacksDeprecated(McpClientAutoConfiguration.java:196) ~[spring-ai-mcp-client-spring-boot-autoconfigure-1.0.0-M6.jar:1.0.0-M6]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.lambda$instantiate$0(SimpleInstantiationStrategy.java:171) ~[spring-beans-6.2.5.jar:6.2.5]
	... 24 common frames omitted
```

## Scenario 2: ASYNC Mode (Application Starts but with Duplicate Tools)

Configuration:
```yaml
spring:
  ai:
    mcp:
      client:
        type: ASYNC
```

Log output:
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.4)

2025-03-25T17:10:18.099+08:00  INFO 15692 --- [ai-mcp-clinet] [           main] com.qjc.SpringAiMcpClinetApplication     : Starting SpringAiMcpClinetApplication using Java 17.0.12 with PID 15692 (C:\Users\capitek-qijch\ai-project\spring-ai-bug\spring-ai-mcp-clinet\target\classes started by capitek-qijch in C:\Users\capitek-qijch\ai-project\spring-ai-bug)
2025-03-25T17:10:18.103+08:00 DEBUG 15692 --- [ai-mcp-clinet] [           main] com.qjc.SpringAiMcpClinetApplication     : Running with Spring Boot v3.4.4, Spring v6.2.5
2025-03-25T17:10:18.104+08:00  INFO 15692 --- [ai-mcp-clinet] [           main] com.qjc.SpringAiMcpClinetApplication     : No active profile set, falling back to 1 default profile: "default"
2025-03-25T17:10:19.226+08:00  INFO 15692 --- [ai-mcp-clinet] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2025-03-25T17:10:19.240+08:00  INFO 15692 --- [ai-mcp-clinet] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-03-25T17:10:19.240+08:00  INFO 15692 --- [ai-mcp-clinet] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.39]
2025-03-25T17:10:19.299+08:00  INFO 15692 --- [ai-mcp-clinet] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-03-25T17:10:19.300+08:00  INFO 15692 --- [ai-mcp-clinet] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1136 ms
2025-03-25T17:10:20.225+08:00  WARN 15692 --- [ai-mcp-clinet] [ient-2-Worker-2] i.m.spec.DefaultMcpSession               : Unexpected response for unkown id 6bfdde11-1
2025-03-25T17:10:20.252+08:00  WARN 15692 --- [ai-mcp-clinet] [ient-1-Worker-2] i.m.spec.DefaultMcpSession               : Unexpected response for unkown id ed00fabe-1
2025-03-25T17:10:20.326+08:00  INFO 15692 --- [ai-mcp-clinet] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-03-25T17:10:20.335+08:00  INFO 15692 --- [ai-mcp-clinet] [           main] com.qjc.SpringAiMcpClinetApplication     : Started SpringAiMcpClinetApplication in 3.033 seconds (process running for 4.002)
2025-03-25T17:11:14.694+08:00  INFO 15692 --- [ai-mcp-clinet] [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-03-25T17:11:14.694+08:00  INFO 15692 --- [ai-mcp-clinet] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-03-25T17:11:14.695+08:00  INFO 15692 --- [ai-mcp-clinet] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2025-03-25T17:11:18.702+08:00  INFO 15692 --- [ai-mcp-clinet] [nio-8080-exec-2] com.qjc.controller.HelloController       : 已注册的工具回调：
2025-03-25T17:11:18.713+08:00  WARN 15692 --- [ai-mcp-clinet] [ient-2-Worker-0] i.m.spec.DefaultMcpSession               : Unexpected response for unkown id 6bfdde11-2
2025-03-25T17:11:18.719+08:00  WARN 15692 --- [ai-mcp-clinet] [ient-1-Worker-1] i.m.spec.DefaultMcpSession               : Unexpected response for unkown id ed00fabe-2
2025-03-25T17:11:18.719+08:00  INFO 15692 --- [ai-mcp-clinet] [nio-8080-exec-2] com.qjc.controller.HelloController       : 工具名称: get_addr_date, 描述: 获取指定地点的当前时间
2025-03-25T17:11:18.719+08:00  INFO 15692 --- [ai-mcp-clinet] [nio-8080-exec-2] com.qjc.controller.HelloController       : 工具名称: get_addr_date, 描述: 获取指定地点的当前时间
```

## Code Analysis

In `McpClientAutoConfiguration.java`, both transport implementations are registered without mutual exclusion:

```java
@AutoConfiguration(after = { StdioTransportAutoConfiguration.class, SseHttpClientTransportAutoConfiguration.class,
        SseWebFluxTransportAutoConfiguration.class })
@ConditionalOnClass({ McpSchema.class })
@EnableConfigurationProperties(McpClientCommonProperties.class)
@ConditionalOnProperty(prefix = McpClientCommonProperties.CONFIG_PREFIX, name = "enabled", havingValue = "true",
        matchIfMissing = true)
public class McpClientAutoConfiguration {
    // ...
}
```

This leads to both `SseHttpClientTransportAutoConfiguration` and `SseWebFluxTransportAutoConfiguration` being activated simultaneously when the required dependencies are present, causing duplicate tools registration. 