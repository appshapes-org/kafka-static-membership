package org.appshapes.common.kafka.consumer

import org.springframework.context.annotation.Bean
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.stereotype.Component

@Component
class GetKafkaListenerContainerFactoryCommand(private val factory: ConsumerFactory<String, ByteArray>) {
    @Bean
    fun getKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, ByteArray> {
        val containerFactory = ConcurrentKafkaListenerContainerFactory<String, ByteArray>()
        containerFactory.consumerFactory = factory
        return containerFactory
    }
}