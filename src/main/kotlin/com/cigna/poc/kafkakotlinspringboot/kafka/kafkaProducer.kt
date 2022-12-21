package com.cigna.poc.kafkakotlinspringboot.kafka

import com.cigna.poc.kafkakotlinspringboot.model.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer(private val kafkaTemplate: KafkaTemplate<String, String>) {
    private val LOGGER: Logger = LoggerFactory.getLogger(KafkaProducer::class.java)

    fun sendMessage(message: String) {
        LOGGER.info(String.format("Message Sent : %s", message))
        kafkaTemplate.send("PERSISTER", message.toString())
    }
}