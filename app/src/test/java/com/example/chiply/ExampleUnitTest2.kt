package com.example.chiply

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest2 {
    @Test
    fun printDiscount() {
        println(formatPrice(10.0, "кг", 20))
        calculateKvadratnoeUravnenie(1.0, 4.0, 3.0)
    }
}