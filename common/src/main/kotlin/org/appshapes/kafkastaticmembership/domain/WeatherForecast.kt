package org.appshapes.kafkastaticmembership.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class WeatherForecast(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    @JsonProperty("current_weather")
    val current: WeatherMeasurement
)