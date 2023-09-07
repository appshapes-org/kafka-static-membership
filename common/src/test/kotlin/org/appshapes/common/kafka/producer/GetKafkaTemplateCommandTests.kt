package org.appshapes.common.kafka.producer

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.springframework.kafka.core.ProducerFactory

class GetKafkaTemplateCommandTests {
    @Suppress("UNCHECKED_CAST")
    @Test
    fun getKafkaTemplate_ReturnsKafkaTemplate() {
        val template = GetKafkaTemplateCommand(mock(ProducerFactory::class.java) as ProducerFactory<String, ByteArray>)
            .getKafkaTemplate()
        assertNotNull(template)
    }
}