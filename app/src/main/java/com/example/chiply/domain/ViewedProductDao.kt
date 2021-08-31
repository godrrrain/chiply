package com.example.chiply.domain

interface ViewedProductDao {

    fun addProduct(productId: Int)

    fun getAllProducts(): List<Int>
}