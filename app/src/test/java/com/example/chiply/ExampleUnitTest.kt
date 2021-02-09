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
class ExampleUnitTest {
    @Test
    fun printDiscount() {
        println(formatPrice(10.0, "кг", 20))
        calculateKvadratnoeUravnenie(1.0, 4.0, 3.0)
    }
}

fun formatPrice(price: Double, measure: String = "шт", discountPercent: Int): String {

    return if (discountPercent != 0) {
        val discountPrice = price - (price * discountPercent / 100)
        "$discountPrice/$measure(скидка $discountPercent%)"
    } else {
        "$price/$measure"
    }
}

fun calculateKvadratnoeUravnenie(a: Double = 0.0, b: Double = 0.0, c: Double = 0.0) {

    val discriminant = b.pow(2.0) - 4 * a * c

    when {
        discriminant > 0.0 -> {
            val x1 = (-b - sqrt(discriminant)) / (2 * a)
            val x2 = (-b + sqrt(discriminant)) / (2 * a)
            println("Первый корень - $x1. Второй корень - $x2")
        }
        discriminant == 0.0 -> {
            val x1 = (-b) / (2 * a)
            println("Один корень - $x1")
        }
        else -> {
            println("Решений нет")
        }
    }
}