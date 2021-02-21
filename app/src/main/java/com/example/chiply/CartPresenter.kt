package com.example.chiply

class CartPresenter(
        private val view: ProductsView
) {
    private val laysChips = Product("Лейс",80.0, 20)
    private val pringlsChips = Product("Принглз",180.0, 10)

    private val products = listOf(laysChips, pringlsChips)

    private val mainCart = Cart(products)

    fun cartPrint() {
        view.printCart(mainCart)
    }
}