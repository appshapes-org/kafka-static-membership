package org.appshapes.kafkastaticmembership.domain

import org.appshapes.common.testing.ExcludeFromGeneratedCoverage

@ExcludeFromGeneratedCoverage
data class WeatherMeasurement(
    val temperature: Double,
    val windspeed: Double,
    val time: String
)