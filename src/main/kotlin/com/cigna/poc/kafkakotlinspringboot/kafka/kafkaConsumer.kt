package com.cigna.poc.kafkakotlinspringboot.kafka

import com.cigna.poc.kafkakotlinspringboot.model.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {
    private val LOGGER: Logger = LoggerFactory.getLogger(KafkaConsumer::class.java)

//    @KafkaListener(topics = ["PERSISTER"], groupId = "persister-group")
    fun consumer(message: String) {
        LOGGER.info(String.format("Message Received : %s", message.toString()))
    }
}