package org.appshapes.kafkastaticmembership.consumer

import org.appshapes.common.logging.err
import org.appshapes.common.logging.getLogger
import org.appshapes.common.logging.inf
import org.appshapes.kafkastaticmembership.protos.WeatherForecastProtoOuterClass.WeatherForecastProto
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class Service {
    private companion object {
        val logger = getLogger()
    }

    @KafkaListener(topics = ["\${weatherforecast.topic}"])
    fun execute(message: ByteArray) {
        try {
            val forecast = WeatherForecastProto.newBuilder().mergeFrom(message).build()
            logger.inf("Received {}", forecast)
        } catch (e: Exception) {
            logger.err(e, "Error consuming")
        }
    }
}