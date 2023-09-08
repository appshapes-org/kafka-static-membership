package org.appshapes.common.kafka.consumer

import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.stereotype.Component

@Component
class GetConsumerFactoryCommand(private val config: Map<String, Any>) {
    @Bean
    fun <K, V> getConsumerFactory(): ConsumerFactory<K, V> {
        return DefaultKafkaConsumerFactory(config)
    }
}