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
    fun divideTest() {
        assertEquals(2, 2 / 4)
    }


    @Test
    fun multiplicationTest() {
        assertEquals(4, 2 * 2)
    }
}