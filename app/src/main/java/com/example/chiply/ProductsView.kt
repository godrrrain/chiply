package com.example.chiply

interface ProductsView {

    fun print(name: String)

    fun print(price: Double)

    fun printCart(cart: Cart)
}