package com.example.dgsplayground.graphql.resolvers

import com.example.dgsplayground.application.UserApplication
import com.example.dgsplayground.domain.User
import com.example.dgsplayground.domain.UserParam
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class UserMutation(
    private val application: UserApplication
) {
    @DgsMutation
    fun createUser(@InputArgument param: UserParam): User {
        return application.createUser(param)
    }
}