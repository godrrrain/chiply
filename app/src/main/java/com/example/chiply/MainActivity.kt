package com.example.chiply

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity(), ProductsView {

    private val productPresenter = ProductsPresenter(this)
    private val cartPresenter = CartPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productPresenter.pricePrint()
        cartPresenter.cartPrint()
    }

    override fun print(name: String) {
        TODO("Not yet implemented")
    }

    override fun print(price: Double) {
        Toast.makeText(this, "Price : $price", Toast.LENGTH_LONG).show()
    }

    override fun printCart(cart: Cart) {
        val products = cart.getProductList()
        products.forEach {
            println("${it.getName()} со скидкой стоит = ${it.calcDiscountPrice()} руб")
        }
        println("Суммарная стоимость корзины = ${cart.getOverallDiscountPrice()} руб")
    }
}