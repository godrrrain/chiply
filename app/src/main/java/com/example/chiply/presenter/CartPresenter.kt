package com.example.chiply.presenter

import com.example.chiply.domain.model.Product
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class CartPresenter : MvpPresenter<CartView>() {

    private val products = mutableListOf(
            Product("Лейс. Краб. 150гр", 90.0, 20),
            Product("Принглз. Краб. 160гр", 130.0, 20),
            Product("Принглз. Лук. 160гр", 130.0, 10),
            Product("Читос. Кетчуп. 55гр", 40.0, 30),
            Product("Лейс. Сыр. 150гр", 100.0, 10)
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        setData()
    }

    private fun setData() {
        viewState.setCart(products)
    }

    fun removeItem(product: Product) {
        val position = products.indexOf(product)
        products.removeAt(position)
        viewState.removeItem(position)
    }
}