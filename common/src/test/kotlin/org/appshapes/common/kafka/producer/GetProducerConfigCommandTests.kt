package org.appshapes.common.kafka.producer

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.ByteArraySerializer
import org.apache.kafka.common.serialization.StringSerializer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetProducerConfigCommandTests {
    @Test
    fun getProducerConfig_ReturnsRequiredKeys() {
        val command = GetProducerConfigCommand(
            "localhost:9092",
            StringSerializer::class.java.name,
            ByteArraySerializer::class.java.name
        )
        val config = command.getProducerConfig()
        assertEquals("localhost:9092", config[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG])
        assertEquals(StringSerializer::class.java.name, config[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG])
        assertEquals(ByteArraySerializer::class.java.name, config[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG])
    }
}