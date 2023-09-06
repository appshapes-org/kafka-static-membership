package org.appshapes.kafkastaticmembership.producer

import org.appshapes.kafkastaticmembership.domain.WeatherForecast
import org.appshapes.kafkastaticmembership.protos.WeatherForecastProtoOuterClass
import org.appshapes.kafkastaticmembership.protos.WeatherForecastProtoOuterClass.WeatherForecastProto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

@Component
class GetWeatherForecastCommand(
    private val rest: RestTemplate
) {
    @Value("\${weatherforecast.url}")
    private val weatherForecastUrl = ""

    fun execute(): WeatherForecastProto {
        val forecast = getWeatherForecast()
        return transformWeatherForecast(forecast)
    }

    protected fun getWeatherForecast(): WeatherForecast {
        val url = weatherForecastUrl
            .replace("LATITUDE", "${Random.nextInt(-90, 91)}")
            .replace("LONGITUDE", "${Random.nextInt(-180, 181)}")
        return rest.getForObject(url, WeatherForecast::class.java)!!
    }

    protected fun transformWeatherForecast(forecast: WeatherForecast): WeatherForecastProto {
        return WeatherForecastProto.newBuilder()
            .setLatitude(forecast.latitude)
            .setLongitude(forecast.longitude)
            .setTimezone(forecast.timezone)
            .setCurrent(
                WeatherForecastProtoOuterClass.WeatherMeasurementProto.newBuilder()
                    .setTemperature(forecast.current.temperature)
                    .setWindspeed(forecast.current.windspeed)
                    .setTimestamp(getWeatherForecastDateTime(forecast).toEpochSecond())
            )
            .build()
    }

    protected fun getWeatherForecastDateTime(forecast: WeatherForecast): ZonedDateTime {
        return ZonedDateTime.parse(
            forecast.current.time,
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm").withZone(ZoneId.of(forecast.timezone))
        )
    }
}