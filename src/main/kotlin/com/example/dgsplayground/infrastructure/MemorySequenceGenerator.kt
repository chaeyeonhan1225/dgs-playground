package com.example.dgsplayground.infrastructure

import com.example.dgsplayground.domain.SequenceGenerator
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class MemorySequenceGenerator: SequenceGenerator {
    companion object {
        private var sequenceMap: ConcurrentHashMap<String, Long> = ConcurrentHashMap()
    }
    override fun generate(name: String): Long {
        var sequence = sequenceMap[name] ?: 0L
        sequenceMap[name] = ++sequence
        return sequence
    }
}