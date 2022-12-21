package com.cigna.poc.kafkakotlinspringboot.kafka

import com.cigna.poc.kafkakotlinspringboot.model.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class JsonKafkaProducer(private val jsonKafkaTemplate:KafkaTemplate<String,User>) {

    private val LOGGER :Logger = LoggerFactory.getLogger(JsonKafkaProducer::class.java)
    fun sendMessage(data:User){
        LOGGER.info(java.lang.String.format("Message Sent : %s", data.toString()))
        val message:Message<User> = MessageBuilder
            .withPayload(data)
            .setHeader(KafkaHeaders.TOPIC,"INPUT")
            .build()
        jsonKafkaTemplate.send(message)
    }
}