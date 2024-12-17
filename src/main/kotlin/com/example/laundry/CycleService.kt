package com.example.laundry

import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@Service
class CycleService {
    private val cycles = ConcurrentHashMap<String, Cycle>()

    fun startCycle(userId: String, deviceId: String): String {
        val cycleId = UUID.randomUUID().toString()
        val cycle = Cycle(cycleId, userId, deviceId, "IN_PROGRESS")
        cycles[cycleId] = cycle
        return cycleId
    }

    fun getCycle(id: String): Cycle {
        return cycles[id] ?: throw RuntimeException("Cycle not found")
    }
}
