package com.example.chiply

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