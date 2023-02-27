package com.example.dgsplayground.graphql.resolvers

import com.example.dgsplayground.domain.User
import com.example.dgsplayground.domain.UserRepository
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException

@DgsComponent
class UserFetcher(
    private val repository: UserRepository
) {
    private val dummyUsers = listOf<User>(User(id = 1L, nickname = "foo"), User(id = 2L, nickname = "tester"))

    @DgsQuery
    // @DgsData(parentType = "Query", field = "users")
    fun users(): List<User> {
        return repository.findAll()
    }

    @DgsQuery
    fun user(@InputArgument id: Long): User {
        val user = repository.findById(id) ?: throw NotFoundException()
        return user
    }
}