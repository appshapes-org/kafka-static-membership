package org.appshapes.common.kafka

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.stereotype.Component

@Component
class GetKafkaTemplateCommand(private val factory: ProducerFactory<String, ByteArray>) {
    @Value("\${spring.kafka.template.default-topic}")
    private val defaultTopic: String = ""

    @Bean
    fun getKafkaTemplate(): KafkaTemplate<String, ByteArray> {
        val template = KafkaTemplate(factory)
        template.defaultTopic = defaultTopic
        return template
    }
}