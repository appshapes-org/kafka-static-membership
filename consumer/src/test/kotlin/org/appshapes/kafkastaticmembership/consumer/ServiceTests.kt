package org.appshapes.kafkastaticmembership.consumer

import com.google.protobuf.InvalidProtocolBufferException
import org.appshapes.kafkastaticmembership.domain.GetWeatherForecastProtoCommand
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.slf4j.Logger
import java.time.ZoneId
import java.time.ZonedDateTime

@Suppress("KotlinPlaceholderCountMatchesArgumentCount")
class ServiceTests {
    @Test
    fun execute_LogsError_WhenMessageIsNotValid() {
        val logger = mock(Logger::class.java)
        StubService(logger).execute(byteArrayOf(0))
        verify(logger).error(eq("Error consuming"), any(InvalidProtocolBufferException::class.java))
    }

    @Test
    fun execute_LogsWeatherForecast_WhenMessageIsValid() {
        val message = GetWeatherForecastProtoCommand()
            .execute(42.0, 42.0, "GMT", 42.0, 42.0, ZonedDateTime.now(ZoneId.of("GMT")).toEpochSecond())
            .toByteArray()
        val logger = mock(Logger::class.java)
        StubService(logger).execute(message)
        verify(logger).info("Received {}")
    }

    private class StubService(private val logger: Logger) : Service() {
        override fun logInfo(message: String, vararg values: Any) {
            super.logInfo(message, *values)
            logger.info(message)
        }

        override fun logError(error: Throwable, message: String, vararg values: Any) {
            super.logError(error, message, *values)
            logger.error(message, error)
        }
    }
}