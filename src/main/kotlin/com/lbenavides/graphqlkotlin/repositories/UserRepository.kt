package com.lbenavides.graphqlkotlin.repositories

import com.lbenavides.graphqlkotlin.model.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ReactiveMongoRepository<User,String> {
}