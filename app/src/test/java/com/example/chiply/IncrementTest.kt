package com.example.chiply

import org.junit.Test

import org.junit.Assert.*

class IncrementTest {

    @Test
    fun incrementTest() {
        var i = 1
        i += 1
        assertEquals(2, i)
    }

    @Test
    fun multiplicationTest() {
        assertEquals(4, 2 * 2)
    }
}
