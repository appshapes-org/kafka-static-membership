package org.appshapes.kafkastaticmembership.producer

import org.appshapes.kafkastaticmembership.domain.GetWeatherForecastProtoCommand
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito
import org.slf4j.Logger
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.client.RestClientException

class ServiceTests {
    @Suppress("UNCHECKED_CAST")
    @Test
    fun execute_ProducesWeatherForecast() {
        val producer: KafkaTemplate<String, ByteArray> = Mockito.mock(KafkaTemplate::class.java) as KafkaTemplate<String, ByteArray>
        val retriever = Mockito.mock(GetWeatherForecastCommand::class.java)
        Mockito.`when`(retriever.execute())
            .thenReturn(GetWeatherForecastProtoCommand().execute(42.0, 42.0, "GMT", 42.0, 42.0, 1694120547))
        Service(producer, retriever).execute()
        Mockito.verify(producer).sendDefault(eq("42.0, 42.0"), any(ByteArray::class.java))
    }

    @Suppress("UNCHECKED_CAST")
    @Test
    fun execute_LogsErrorWhenExceptionIsCaught() {
        val producer: KafkaTemplate<String, ByteArray> = Mockito.mock(KafkaTemplate::class.java) as KafkaTemplate<String, ByteArray>
        val retriever = Mockito.mock(GetWeatherForecastCommand::class.java)
        Mockito.`when`(retriever.execute())
            .thenThrow(RestClientException("42"))
        val logger = Mockito.mock(Logger::class.java)
        StubService(producer, retriever, logger).execute()
        Mockito.verify(logger).error(eq("Error producing"), any(RestClientException::class.java))
    }

    private class StubService(
        producer: KafkaTemplate<String, ByteArray>,
        retriever: GetWeatherForecastCommand,
        private val logger: Logger
    ) : Service(producer, retriever) {
        override fun logError(error: Throwable, message: String, vararg values: Any) {
            super.logError(error, message, *values)
            logger.error(message, error)
        }
    }
}