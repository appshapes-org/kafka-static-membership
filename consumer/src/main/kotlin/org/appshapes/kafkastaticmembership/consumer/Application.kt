package org.appshapes.kafkastaticmembership.consumer

import org.appshapes.common.runtime.ApplicationBase
import org.appshapes.common.testing.ExcludeFromGeneratedCoverage
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling

@ComponentScan(
    basePackages = [
        "org.appshapes.common.kafka.consumer",
        "org.appshapes.kafkastaticmembership.consumer"]
)
@ConfigurationPropertiesScan(
    basePackages = [
        "org.appshapes.common.kafka.consumer"]
)
@EnableScheduling
@ExcludeFromGeneratedCoverage
@SpringBootApplication
class Application : ApplicationBase()

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}