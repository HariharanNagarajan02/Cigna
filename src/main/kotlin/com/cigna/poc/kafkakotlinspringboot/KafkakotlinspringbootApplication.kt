package com.cigna.poc.kafkakotlinspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkakotlinspringbootApplication

fun main(args: Array<String>) {
	runApplication<KafkakotlinspringbootApplication>(*args)
}
