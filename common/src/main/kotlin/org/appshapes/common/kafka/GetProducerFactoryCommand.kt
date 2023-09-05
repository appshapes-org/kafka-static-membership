package org.appshapes.common.kafka

import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.ProducerFactory
import org.springframework.stereotype.Component

@Component
class GetProducerFactoryCommand(private val config: Map<String, Any>) {
    @Bean
    fun <K, V> getProducerFactory(): ProducerFactory<K, V> {
        return DefaultKafkaProducerFactory(config)
    }
}