package org.appshapes.common.web

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class GetRestTemplateCommand {
    @Bean
    fun getRestTemplate(): RestTemplate {
        return RestTemplate()
    }
}