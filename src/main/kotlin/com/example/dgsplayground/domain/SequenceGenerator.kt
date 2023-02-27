package com.example.dgsplayground.domain

interface SequenceGenerator {
    fun generate(name: String): Long
}