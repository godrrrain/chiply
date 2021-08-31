package com.example.chiply.presenter

import com.example.chiply.domain.ViewedProductDao
import moxy.MvpPresenter

class CatalogPresenter() : MvpPresenter<CatalogView>() {

    private val list = mutableListOf(
            "Лейс",
            "Чииитос",
            "Принглз",
            "Московский картофель"
    )

    override fun attachView(view: CatalogView?) {
        super.attachView(view)
        //val productIds = viewedProductDao.getAllProducts()
        //viewState.showProductIds(productIds)
    }

    fun setData() {
        viewState.setCategories(list)
    }
}