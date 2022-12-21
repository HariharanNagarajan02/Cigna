package com.cigna.poc.kafkakotlinspringboot.model

class User(    val requestId :Int?,
               val message:UserDetail?) {

    override fun toString() : String{
        return "{ requestId: $requestId , message:${message.toString()}"
    }
}