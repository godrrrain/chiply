package com.example.chiply

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun printDiscount() {

        val laysChips = Product(80.0, 20)
        val pringlsChips = Product(180.0, 10)

        val pricePrinter: PricePrinter = CleanKotlinPricePrinter()

        val list = listOf(laysChips, pringlsChips)
        list.forEach {
            pricePrinter.print(it.calcDiscountPrice())
        }

    }
}

class Product (
        private val price: Double,
        private val discountPercent: Int = 0
) {
    fun calcDiscountPrice(): Double = price - (price * discountPercent / 100)
}

interface PricePrinter {
    fun print(price: Double)
}

class CleanKotlinPricePrinter : PricePrinter {
    override fun print(price: Double) {
        if (price > 100) {
            println("Цена - $price руб. Дороговато чет")
        } else {
            println("Цена - $price руб. Норм тема")
        }
    }

}
