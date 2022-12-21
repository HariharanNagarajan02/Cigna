package com.cigna.poc.kafkakotlinspringboot.model

class UserDetail(
     val name:String?,
     val age:Int?,
     val dob:String?,
     val country:String?,
     val state:String?,
     val aadharId:String?,
     val passportId:String?,
     val voterId:String?) {

    override fun toString(): String {
        return "{ name:$name, age:$age, dob:$dob, country:$country, state:$state, aadharId:$aadharId, " +
                "passportId:$passportId, voterId:$voterId}"
    }
}