package com.qjc.test;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.spec.ClientMcpTransport;
import io.modelcontextprotocol.spec.McpSchema;

import java.util.Map;

public class SampleClient {

	private final ClientMcpTransport transport;

	public SampleClient(ClientMcpTransport transport) {
		this.transport = transport;
	}

	public void run() {

		var client = McpClient.sync(this.transport).build();

		client.initialize();

		client.ping();

		// List and demonstrate tools
		McpSchema.ListToolsResult toolsList = client.listTools();
		for (McpSchema.Tool tool : toolsList.tools()) {
			System.out.println(tool);
		}
		System.out.println("Available Tools = " + toolsList);

		// 按照正确的格式构造请求参数
		Map<String, Object> userSearchRequest = Map.of("address", "北京");
		Map<String, Object> requestParams = Map.of("request", userSearchRequest);
		
		McpSchema.CallToolResult cityResult = client.callTool(
				new McpSchema.CallToolRequest("get_addr_date", requestParams));
		System.out.println(cityResult.content());

		client.closeGracefully();

	}

}