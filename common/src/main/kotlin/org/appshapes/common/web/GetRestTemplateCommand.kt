package org.appshapes.common.web

import org.appshapes.common.testing.ExcludeFromGeneratedCoverage
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@ExcludeFromGeneratedCoverage
@Component
class GetRestTemplateCommand {
    @Bean
    fun getRestTemplate(): RestTemplate {
        return RestTemplate()
    }
}