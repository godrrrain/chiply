package com.example.chiply.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chiply.presenter.CartPresenter
import com.example.chiply.domain.model.Product
import com.example.chiply.R
import com.example.chiply.presenter.CartView
import kotlinx.android.synthetic.main.cart_layout.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class CartActivity : MvpAppCompatActivity(), CartView {

    private val presenter by moxyPresenter { CartPresenter() }
    private val adapter = CartAdapter { product ->
        presenter.removeItem(product)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_layout)

        cartCreateOrderBtn.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
        }

        cartBack.setOnClickListener {
            finish()
        }

        cartRv.layoutManager = LinearLayoutManager(this)
        cartRv.adapter = adapter
    }

    override fun setCart(cart: List<Product>) {
        adapter.setData(cart)
    }

    override fun removeItem(position: Int) {
        adapter.notifyItemRemoved(position)
    }
}