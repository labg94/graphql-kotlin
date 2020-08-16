package com.lbenavides.graphqlkotlin.services

import com.lbenavides.graphqlkotlin.model.User
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserService {

   fun getAll() : Flux<User>

    fun getOne(): Mono<User>


    fun mockData(): List<User>
    fun mockDataByName(name: String): List<User>
    fun mockDataByLastName(lastName: String): List<User>
    fun mockDataByAge(age: Int): List<User>

}