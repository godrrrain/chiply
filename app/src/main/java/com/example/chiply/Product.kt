package com.example.chiply

class Product (
        private val name: String,
        private val price: Double,
        private val discountPercent: Int = 0
) {
    fun calcDiscountPrice(): Double = price - (price * discountPercent / 100)

    fun getName(): String = name
}