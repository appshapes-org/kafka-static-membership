package org.appshapes.kafkastaticmembership.domain

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WeatherForecastTests {
    @Test
    fun weatherForecast_MapsToExpectedJson() {
        val mapper = jacksonObjectMapper()
        val expected = WeatherForecast(52.52, 13.419998, "GMT", WeatherMeasurement(13.4, 4.7, "2023-09-04T00:00"))
        val serialization = mapper.writeValueAsString(expected)
        assertEquals("{\"latitude\":52.52,\"longitude\":13.419998,\"timezone\":\"GMT\",\"current_weather\":{\"temperature\":13.4,\"windspeed\":4.7,\"time\":\"2023-09-04T00:00\"}}", serialization)
        val actual: WeatherForecast = mapper.readValue(serialization, WeatherForecast::class.java)
        assertEquals(expected.latitude, actual.latitude)
    }
}