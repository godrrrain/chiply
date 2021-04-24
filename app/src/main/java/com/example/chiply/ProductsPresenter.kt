package com.example.chiply

import moxy.MvpPresenter

class ProductsPresenter : MvpPresenter<ProductsView>() {

    private val laysChips = Product("Лейс",80.0, 20)
    private val pringlsChips = Product("Принглз",180.0, 10)

    private val products = listOf(laysChips, pringlsChips)

    private val model = CreateOrderModel()

    fun checkSecondName(text: String) {
        if (!checkSymbols(text)) model.secondName = text
        viewState.showErrorForSecondName(checkSymbols(text))
    }

    fun checkFirstName(text: String) {
        if (!checkSymbols(text)) model.firstName = text
        viewState.showErrorForFirstName(checkSymbols(text))
    }

    fun checkThirdName(text: String) {
        if (!checkSymbols(text)) model.thirdName = text
        viewState.showErrorForThirdName(checkSymbols(text))
    }

    fun checkPhone(text: String) {
        if ((text.startsWith("8")) && (text.length == 11) || text.startsWith("+7") && (text.length == 12))
        {
            model.phone = text
            viewState.showErrorForPhone(false)
        }
        else viewState.showErrorForPhone(true)
    }

    private fun checkSymbols(text: String): Boolean {
        return text.length < 3
    }

    fun pricePrint() {
        var allPrice = 0.0
        products.forEach { product ->
            allPrice += product.calcDiscountPrice()
        }
        viewState.print(allPrice)
    }

    fun productsNamePrint() {
        products.forEach {
            viewState.print(it.getName())
        }
    }
}