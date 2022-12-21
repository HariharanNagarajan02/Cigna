package com.cigna.poc.kafkakotlinspringboot.controller

import com.cigna.poc.kafkakotlinspringboot.dto.UserDetailsDto
import com.cigna.poc.kafkakotlinspringboot.kafka.JsonKafkaProducer
import com.cigna.poc.kafkakotlinspringboot.kafka.KafkaProducer
import com.cigna.poc.kafkakotlinspringboot.model.User
import com.cigna.poc.kafkakotlinspringboot.repository.UserDetailRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/kafka")
class UserController(private val kafkaProducer: KafkaProducer,
                    private val jsonKafkaProducer:JsonKafkaProducer,
    private val userDetailRepo:UserDetailRepository) {
    @PostMapping("/json/insert")
    fun getData(@RequestBody user: User) : ResponseEntity<String> {
        jsonKafkaProducer.sendMessage(user)
        return ResponseEntity.ok("Working");
    }
    @GetMapping("/insert")
    fun getData(@RequestParam("id") id: String): ResponseEntity<String>{
        kafkaProducer.sendMessage(id)
        return ResponseEntity.ok("Working");
    }

    @PostMapping("/insertData")
    fun insertDataToMangoDb(@RequestBody data:User):ResponseEntity<String>{
        var userDetailsDto = UserDetailsDto()
        userDetailsDto.name= data.message?.name
        userDetailsDto.profession="software Professional"
        userDetailsDto.age=data.message?.age

        var country = UserDetailsDto.Country()
        country.name=data.message?.country
        country.abbr="IN"
        userDetailsDto.country=country

        var state = UserDetailsDto.State()
        state.name=data.message?.state
        state.abbr="TN"
        userDetailsDto.state=state
        userDetailRepo.save(userDetailsDto)
        return return ResponseEntity.ok("Working");
    }
}