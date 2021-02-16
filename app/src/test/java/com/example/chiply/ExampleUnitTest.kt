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

        val laysChips = Product("Лейс",80.0, 20)
        val pringlsChips = Product("Принглз",180.0, 10)

        val pricePrinter: PricePrinter = CleanKotlinPricePrinter()

        val products = listOf(laysChips, pringlsChips)
        val discountPrices = products.map { it.calcDiscountPrice() }

        discountPrices.forEach { discountPrice ->
            pricePrinter.printProduct(discountPrice)
        }

        val mainCart = Cart(products)
        pricePrinter.printCart(mainCart)

    }
}

class Cart (
        private val products: List<Product>
) {
    fun getOverallDiscountPrice(): Double {
        var sum = 0.0
        products.forEach {
            sum += it.calcDiscountPrice()
        }
        return sum
    }
    fun getProductList(): List<Product> {
        return products
    }
}

class Product (
        private val name: String,
        private val price: Double,
        private val discountPercent: Int = 0
) {
    fun calcDiscountPrice(): Double = price - (price * discountPercent / 100)

    fun getName(): String = name
}

interface PricePrinter {
    fun printProduct(price: Double)

    fun printCart(cart: Cart)
}

class CleanKotlinPricePrinter : PricePrinter {
    override fun printProduct(price: Double) {
        if (price > 100) {
            println("Цена - $price руб. Дороговато чет")
        } else {
            println("Цена - $price руб. Норм тема")
        }
    }

    override fun printCart(cart: Cart) {
        val products = cart.getProductList()
        products.forEach {
            println("${it.getName()} со скидкой стоит = ${it.calcDiscountPrice()} руб")
        }
        println("Суммарная стоимость корзины = ${cart.getOverallDiscountPrice()} руб")
    }

}
