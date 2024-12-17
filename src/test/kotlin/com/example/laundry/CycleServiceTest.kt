package com.example.laundry

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CycleServiceTest {

    private val cycleService = CycleService()

    @Test
    fun startCycle_createsNewCycle() {
        val userId = "user1"
        val deviceId = "device1"
        val cycleId = cycleService.startCycle(userId, deviceId)

        val cycle = cycleService.getCycle(cycleId)
        assertEquals(cycleId, cycle.id)
        assertEquals(userId, cycle.userId)
        assertEquals(deviceId, cycle.deviceId)
        assertEquals("IN_PROGRESS", cycle.status)
    }

    @Test
    fun getCycle_returnsExistingCycle() {
        val userId = "user2"
        val deviceId = "device2"
        val cycleId = cycleService.startCycle(userId, deviceId)

        val cycle = cycleService.getCycle(cycleId)
        assertNotNull(cycle)
        assertEquals(cycleId, cycle.id)
    }

    @Test
    fun getCycle_throwsExceptionForNonExistentCycle() {
        assertThrows<RuntimeException> {
            cycleService.getCycle("non-existent-id")
        }
    }
}
