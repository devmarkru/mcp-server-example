package ru.devmark.mcp.server.config

import org.springframework.ai.tool.ToolCallbackProvider
import org.springframework.ai.tool.method.MethodToolCallbackProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.devmark.mcp.server.service.ToolService

@Configuration
class ToolConfig {
    @Bean
    fun toolsProvider(toolService: ToolService): ToolCallbackProvider =
        MethodToolCallbackProvider.builder()
            .toolObjects(toolService)
            .build()
}
