//package com.example.dgsplayground.infrastructure
//
//import com.example.dgsplayground.domain.User
//import com.example.dgsplayground.domain.UserRepository
//import org.springframework.stereotype.Repository
//
//@Repository
//class JPAUserRepository: UserRepository {
//    override fun save(user: User): User {
//        entityManager.persist(user)
//        return user
//    }
//
//    override fun findById(id: Long): User {
//        TODO("Not yet implemented")
//    }
//
//    override fun findAll(): List<User> {
//        TODO("Not yet implemented")
//    }
//}