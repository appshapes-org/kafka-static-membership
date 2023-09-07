package org.appshapes.common.kafka.producer

import org.apache.kafka.common.serialization.ByteArraySerializer
import org.apache.kafka.common.serialization.StringSerializer
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class GetProducerFactoryCommandTests {
    @Test
    fun getProducerFactory_ReturnsProducerFactory() {
        val command = GetProducerConfigCommand(
            "localhost:9092",
            StringSerializer::class.java.name,
            ByteArraySerializer::class.java.name
        )
        val config = command.getProducerConfig()
        val factory = GetProducerFactoryCommand(config)
            .getProducerFactory<String, ByteArray>()
        assertNotNull(factory)
    }
}