package ru.kaplaan.bot.domain.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.DefaultResponseErrorHandler
import org.springframework.web.client.RestClient

@Configuration
class RestClientConfig {
    @Bean
    fun restClient(): RestClient =
        RestClient.builder()
            .defaultStatusHandler(DefaultResponseErrorHandler())
            .build()

}