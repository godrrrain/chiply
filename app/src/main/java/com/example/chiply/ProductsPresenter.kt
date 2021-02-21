package com.example.chiply

class ProductsPresenter(
        private val view: ProductsView
) {

    private val laysChips = Product("Лейс",80.0, 20)
    private val pringlsChips = Product("Принглз",180.0, 10)

    private val products = listOf(laysChips, pringlsChips)

    fun pricePrint() {
        var allPrice = 0.0
        products.forEach { product ->
            allPrice += product.calcDiscountPrice()
        }
        view.print(allPrice)
    }

    fun productsNamePrint() {
        products.forEach {
            view.print(it.getName())
        }
    }
}