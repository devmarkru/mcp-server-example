package ru.devmark.mcp.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class McpServerExampleApplication

fun main(args: Array<String>) {
    runApplication<McpServerExampleApplication>(*args)
}
