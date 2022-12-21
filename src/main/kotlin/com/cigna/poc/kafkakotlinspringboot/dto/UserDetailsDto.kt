package com.cigna.poc.kafkakotlinspringboot.dto

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "UserDetail")
class UserDetailsDto {

    var name:String? = null
    var profession:String?=null
    var age:Int?=null
    var country:Country?=null
    var state:State?=null

    class Country{
        var name:String?=null
        var abbr:String?=null
    }

    class State{
        var name:String?=null
        var abbr:String?=null
    }
}