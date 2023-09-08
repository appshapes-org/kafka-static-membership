package org.appshapes.common.kafka.consumer

import org.apache.kafka.common.serialization.ByteArrayDeserializer
import org.apache.kafka.common.serialization.StringDeserializer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GetKafkaListenerContainerFactoryCommandTests {
    @Test
    fun getKafkaListenerContainerFactory_ReturnsConcurrentKafkaListenerContainerFactory() {
        val command = GetConsumerConfigCommand(
            "localhost:9092",
            "group",
            StringDeserializer::class.java.name,
            ByteArrayDeserializer::class.java.name
        )
        val config = command.getConsumerConfig()
        val consumerFactory = GetConsumerFactoryCommand(config)
            .getConsumerFactory<String, ByteArray>()
        val listenerFactory = GetKafkaListenerContainerFactoryCommand(consumerFactory)
            .getKafkaListenerContainerFactory()
        Assertions.assertNotNull(listenerFactory)
    }
}