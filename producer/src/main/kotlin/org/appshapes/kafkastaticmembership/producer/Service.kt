package org.appshapes.kafkastaticmembership.producer

import org.appshapes.common.logging.err
import org.appshapes.common.logging.getLogger
import org.appshapes.common.logging.inf
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class Service(
    private val producer: KafkaTemplate<String, ByteArray>,
    private val retriever: GetWeatherForecastCommand
) {
    private companion object {
        val logger = getLogger()
    }

    @Scheduled(fixedDelayString = "\${weatherforecast.execute-interval}")
    fun execute() {
        try {
            val forecast = retriever.execute()
            logger.inf("Sending {}", forecast)
            producer.sendDefault("${forecast.latitude}-${forecast.longitude}", forecast.toByteArray())
        } catch (e: Exception) {
            logger.err(e, "Error producing weather forecast")
        }
    }
}