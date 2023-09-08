package org.appshapes.common.kafka.consumer

import org.apache.kafka.common.serialization.ByteArrayDeserializer
import org.apache.kafka.common.serialization.StringDeserializer
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class GetConsumerFactoryCommandTests {
    @Test
    fun getConsumerFactory_ReturnsConsumerFactory() {
        val command = GetConsumerConfigCommand(
            "localhost:9092",
            "group",
            StringDeserializer::class.java.name,
            ByteArrayDeserializer::class.java.name
        )
        val config = command.getConsumerConfig()
        val factory = GetConsumerFactoryCommand(config)
            .getConsumerFactory<String, ByteArray>()
        assertNotNull(factory)
    }
}