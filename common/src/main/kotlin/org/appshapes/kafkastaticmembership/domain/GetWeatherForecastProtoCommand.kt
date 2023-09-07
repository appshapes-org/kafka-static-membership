package org.appshapes.kafkastaticmembership.domain

import org.appshapes.kafkastaticmembership.protos.WeatherForecastProtoOuterClass

class GetWeatherForecastProtoCommand {
    fun execute(
        latitude: Double,
        longitude: Double,
        timezone: String,
        temperature: Double,
        windspeed: Double,
        timestamp: Long
    ): WeatherForecastProtoOuterClass.WeatherForecastProto = WeatherForecastProtoOuterClass.WeatherForecastProto.newBuilder()
        .setLatitude(latitude)
        .setLongitude(longitude)
        .setTimezone(timezone)
        .setCurrent(
            WeatherForecastProtoOuterClass.WeatherMeasurementProto.newBuilder()
                .setTemperature(temperature)
                .setWindspeed(windspeed)
                .setTimestamp(timestamp)
        )
        .build()
}