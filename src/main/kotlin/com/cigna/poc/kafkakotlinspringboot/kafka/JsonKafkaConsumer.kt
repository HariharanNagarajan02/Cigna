package com.cigna.poc.kafkakotlinspringboot.kafka

import com.cigna.poc.kafkakotlinspringboot.dto.UserDetailsDto
import com.cigna.poc.kafkakotlinspringboot.model.User
import com.cigna.poc.kafkakotlinspringboot.repository.UserDetailRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class JsonKafkaConsumer(private val repo:UserDetailRepository) {

    private val LOGGER: Logger = LoggerFactory.getLogger(JsonKafkaConsumer::class.java)

    @KafkaListener(topics = ["INPUT"], groupId = "input-group")
    fun consumer(message: User) {
        buildOutputJsonFormatDataFromTopic(message);
        LOGGER.info(String.format("Message Consumed : %s", message.toString()))
    }

    private fun buildOutputJsonFormatDataFromTopic(data: User) {

        var userDetailsDto = UserDetailsDto()
        userDetailsDto.name= data.message?.name
        userDetailsDto.profession="software Professional"
        userDetailsDto.age=data.message?.age

        var country = UserDetailsDto.Country()
        country.name=data.message?.country
        country.abbr="IN"
        userDetailsDto.country=country

        var state =UserDetailsDto.State()
        state.name=data.message?.state
        state.abbr="TN"
        userDetailsDto.state=state
        repo.save(userDetailsDto);
    }
}