package ru.devmark.mcp.server.service

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springaicommunity.mcp.annotation.McpTool
import org.springaicommunity.mcp.annotation.McpToolParam
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDateTime

private val logger = KotlinLogging.logger {}

@Service
class ToolService {
    @McpTool(description = "Получить текущую дату и время.")
    fun getTime(): LocalDateTime {
        val now = LocalDateTime.now()
        logger.info { "Now: $now" }
        return now
    }

    @McpTool(description = "Создать напоминание на определённое время.")
    fun createReminder(
        @McpToolParam(description = "Текст напоминания")
        description: String,
        @McpToolParam(description = "Время срабатывания напоминания")
        dateTime: LocalDateTime,
    ): String {
        // логика создания напоминания
        val message = "Напоминание с текстом '$description' сработает $dateTime."
        logger.info { "Message text: $message" }
        return message
    }

    @McpTool(description = "Получить цены на хлеб в разных магазинах.")
    fun getBreadPrices(): Map<String, BigDecimal> {
        logger.info { "Getting prices for bread in various stores." }
        return mapOf(
            "Лента" to BigDecimal("60.00"),
            "Пятёрочка" to BigDecimal("50.00"),
            "Азбука Вкуса" to BigDecimal("100.00"),
        )
    }
}
