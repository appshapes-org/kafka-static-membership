package org.appshapes.kafkastaticmembership.domain

data class WeatherMeasurement(
    val temperature: Double,
    val windspeed: Double,
    val time: String
)