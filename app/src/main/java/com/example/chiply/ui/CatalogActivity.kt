package com.example.chiply.ui

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chiply.R
import com.example.chiply.data.ViewedProductDaoImpl
import com.example.chiply.domain.ViewedProductDao
import com.example.chiply.presenter.CatalogPresenter
import com.example.chiply.presenter.CatalogView
import kotlinx.android.synthetic.main.catalog_layout.*

class CatalogActivity : AppCompatActivity(), CatalogView {

    private val presenter = CatalogPresenter()
    private val adapter = CategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)

        catalogItemBtn.setOnClickListener {
            val intent = Intent(this, ProductInfoActivity::class.java).apply {
                putExtra(PRODUCT_ID, 1000)
            }
            startActivity(intent)
        }

        catalogCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        categoryRv.layoutManager = LinearLayoutManager(this)
        categoryRv.adapter = adapter

        presenter.attachView(this)
        presenter.setData()
    }

    override fun showProductIds(productIds: List<Int>) {
        Toast.makeText(this, productIds.joinToString(","), Toast.LENGTH_LONG).show()
    }

    override fun setCategories(list: List<String>) {
        adapter.setData(list)
    }

    companion object {
        const val PRODUCT_ID = "PRODUCT_ID"
    }
}

val AppCompatActivity.sharedPreferences: SharedPreferences
    get() = getSharedPreferences("data", MODE_PRIVATE)