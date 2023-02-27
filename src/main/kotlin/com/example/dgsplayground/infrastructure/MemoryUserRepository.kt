package com.example.dgsplayground.infrastructure

import com.example.dgsplayground.domain.User
import com.example.dgsplayground.domain.UserRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.concurrent.ConcurrentHashMap

@Repository
class MemoryUserRepository: UserRepository {
    companion object {
        private val store: ConcurrentHashMap<Long, User> = ConcurrentHashMap()
    }

    override fun save(user: User): User {
        store[user.id] = user
        return user
    }

    override fun findById(id: Long): User? {
        return store.get(id)
    }

    override fun findAll(): List<User> {
        val result = store.values.toList()
        return result
    }
}