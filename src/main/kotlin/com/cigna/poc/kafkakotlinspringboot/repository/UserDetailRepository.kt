package com.cigna.poc.kafkakotlinspringboot.repository

import com.cigna.poc.kafkakotlinspringboot.dto.UserDetailsDto
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDetailRepository : MongoRepository<UserDetailsDto,Int> {
}