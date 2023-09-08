package org.appshapes.common.kafka.consumer

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.ByteArrayDeserializer
import org.apache.kafka.common.serialization.StringDeserializer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetConsumerConfigCommandTests {
    @Test
    fun getConsumerConfig_ReturnsRequiredKeys() {
        val command = GetConsumerConfigCommand(
            "localhost:9092",
            "group",
            StringDeserializer::class.java.name,
            ByteArrayDeserializer::class.java.name
        )
        val config = command.getConsumerConfig()
        assertEquals("localhost:9092", config[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG])
        assertEquals("group", config[ConsumerConfig.GROUP_ID_CONFIG])
        assertEquals(StringDeserializer::class.java.name, config[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG])
        assertEquals(ByteArrayDeserializer::class.java.name, config[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG])
    }
}