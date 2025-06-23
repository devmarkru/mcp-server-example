package ru.devmark.mcp.server.service

import org.springframework.ai.tool.annotation.Tool
import org.springframework.ai.tool.annotation.ToolParam
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDateTime

@Service
class ToolService {
    @Tool(description = "Получить текущую дату и время.")
    fun getTime(): LocalDateTime {
        val now = LocalDateTime.now().withHour(10)
        println("Now: $now")
        return now
    }

    @Tool(description = "Создать напоминание на определённое время.")
    fun createReminder(
        @ToolParam(description = "Текст напоминания")
        description: String,
        @ToolParam(description = "Время срабатывания напоминания")
        dateTime: LocalDateTime,
    ): String {
        // логика создания напоминания
        val message = "Напоминание с текстом '$description' сработает $dateTime."
        println(message)
        return message
    }

    @Tool(description = "Получить цены на хлеб в разных магазинах.")
    fun getBreadPrices(): Map<String, BigDecimal> {
        println("Получение цен на хлеб в разных магазинах.")
        return mapOf(
            "Лента" to BigDecimal("60.00"),
            "Пятёрочка" to BigDecimal("50.00"),
            "Азбука Вкуса" to BigDecimal("100.00"),
        )
    }
}
