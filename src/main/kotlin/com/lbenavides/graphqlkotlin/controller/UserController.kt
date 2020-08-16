package com.lbenavides.graphqlkotlin.controller

import com.lbenavides.graphqlkotlin.model.User
import com.lbenavides.graphqlkotlin.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("user")
class UserController (private val userService: UserService){

    @GetMapping
    fun getAll(): List<User> = userService.mockData()


}