package org.appshapes.common.kafka.producer

import org.apache.kafka.clients.producer.ProducerConfig
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Bean

@ConstructorBinding
@ConfigurationProperties("spring.kafka.producer")
class GetProducerConfigCommand(
    private val bootstrapServers: String,
    private val keySerializer: String,
    private val valueSerializer: String
) {
    @Bean
    fun getProducerConfig(): Map<String, Any> {
        return mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServers,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to keySerializer,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to valueSerializer
        )
    }
}