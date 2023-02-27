package com.example.dgsplayground.application

import com.example.dgsplayground.domain.SequenceGenerator
import com.example.dgsplayground.domain.User
import com.example.dgsplayground.domain.UserParam
import com.example.dgsplayground.domain.UserRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserApplication(
    private val sequenceGenerator: SequenceGenerator,
    private val repository: UserRepository
) {
    fun createUser(param: UserParam): User {
        val userId = sequenceGenerator.generate(User::javaClass.name)
        val user = User(id = userId, nickname = param.nickname)
        return repository.save(user)
    }

    fun deleteUser(id: Long): Boolean {
        repository.findById(id) ?: throw NotFoundException()
        return true
    }
}