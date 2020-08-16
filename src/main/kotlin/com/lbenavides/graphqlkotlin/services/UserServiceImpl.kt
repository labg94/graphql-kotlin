package com.lbenavides.graphqlkotlin.services

import com.expediagroup.graphql.annotations.GraphQLIgnore
import com.expediagroup.graphql.spring.operations.Query
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.lbenavides.graphqlkotlin.model.User
import com.lbenavides.graphqlkotlin.repositories.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService, Query {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    override fun getAll(): Flux<User> {
        val just = Flux.just(User("1", "Luis", "Benavides", 1))
        log.info("just => $just")
        return just
    }

    override fun getOne(): Mono<User> = userRepository.findById("5e89260f31c3090abc718be7")


    override fun mockData(): List<User> {
        return getMockData()
    }

    override fun mockDataByName(name: String): List<User> = getMockData().filter { it.name == name }


    override fun mockDataByLastName(lastName: String): List<User> = getMockData().filter { it.lastName == lastName }

    override fun mockDataByAge(age: Int): List<User> = getMockData().filter { it.age == age }


    @GraphQLIgnore
    private fun getMockData(): List<User> {
        val mapper = jacksonObjectMapper()
        val dummyDate = readFileAsLinesUsingGetResourceAsStream("/data/MOCK_DATA.json")
                .reduce { acc, s -> "$acc\n$s" }

        return mapper.readValue(dummyDate)
    }

    @GraphQLIgnore
    fun readFileAsLinesUsingGetResourceAsStream(fileName: String) = this::class.java.getResourceAsStream(fileName).bufferedReader().readLines()

}





