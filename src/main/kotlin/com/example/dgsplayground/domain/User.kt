package com.example.dgsplayground.domain

class User(
    val id: Long,
    nickname: String
) {
    var nickname = nickname
        private set

    var status = CommonState.ACTIVE
        private set

    var grade = UserGrade.BRONZE
        private set

    fun update(param: UserParam) {
        nickname = param.nickname
    }

    fun upgrade() {

    }

    fun delete() {
        status = CommonState.DELETED
    }
}