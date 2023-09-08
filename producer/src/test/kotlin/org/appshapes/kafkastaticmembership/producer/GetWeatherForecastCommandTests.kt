package org.appshapes.kafkastaticmembership.producer

import org.appshapes.kafkastaticmembership.domain.WeatherForecast
import org.appshapes.kafkastaticmembership.domain.WeatherMeasurement
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.web.client.RestTemplate

class GetWeatherForecastCommandTests {
    @Test
    fun execute_ReturnsWeatherForecastProto() {
        val template = mock(RestTemplate::class.java)
        `when`(template.getForObject(anyString(), eq(WeatherForecast::class.java)))
            .thenReturn(WeatherForecast(42.0, 42.0, "GMT", WeatherMeasurement(42.0, 42.0, "2023-09-07T20:00")))
        val forecast = GetWeatherForecastCommand(template)
            .execute()
        assertEquals(42.0, forecast.latitude)
    }
}