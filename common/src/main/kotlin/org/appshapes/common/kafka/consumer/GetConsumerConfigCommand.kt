package org.appshapes.common.kafka.consumer

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Bean

@ConstructorBinding
@ConfigurationProperties("spring.kafka.consumer")
class GetConsumerConfigCommand(
    private val bootstrapServers: String,
    private val groupId: String,
    private val keyDeserializer: String,
    private val valueDeserializer: String
) {
    @Bean
    fun getConsumerConfig(): Map<String, Any> {
        return mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServers,
            ConsumerConfig.GROUP_ID_CONFIG to groupId,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to keyDeserializer,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to valueDeserializer
        )
    }
}