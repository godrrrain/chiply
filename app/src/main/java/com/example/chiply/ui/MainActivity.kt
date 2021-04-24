package com.example.chiply.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import com.example.chiply.CartPresenter
import com.example.chiply.ProductsPresenter
import com.example.chiply.ProductsView
import com.example.chiply.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProductsView {

    private val productPresenter = ProductsPresenter()
    private val cartPresenter = CartPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productPresenter.attachView(this)

        checkoutSumValue.text = "10000 Р"
        checkoutPay.setOnClickListener {
            Toast.makeText(this, "Переход на страницу оплаты", Toast.LENGTH_SHORT).show()
        }

        setListeners()

        productPresenter.pricePrint()
        cartPresenter.cartPrint()

    }

    private fun setListeners() {

        checkoutSecondName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                productPresenter.checkSecondName(s.toString())
            }
        })

        checkoutFirstName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                productPresenter.checkFirstName(s.toString())
            }
        })

        checkoutThirdName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                productPresenter.checkThirdName(s.toString())
            }
        })

        checkoutPhone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                productPresenter.checkPhone(s.toString())
            }
        })
    }

    override fun print(name: String) {
        TODO("Not yet implemented")
    }

    override fun print(price: Double) {
        Toast.makeText(this, "Price : $price", Toast.LENGTH_LONG).show()
    }

    override fun showErrorForSecondName(visible: Boolean) {
        checkoutSecondName.showError(visible)
    }

    override fun showErrorForFirstName(visible: Boolean) {
        checkoutFirstName.showError(visible)
    }

    override fun showErrorForThirdName(visible: Boolean) {
        checkoutThirdName.showError(visible)
    }

    override fun showErrorForPhone(visible: Boolean) {
        checkoutPhone.showError(visible)
    }

    fun EditText.showError(visible: Boolean) {
        val drawable = if (visible) R.drawable.ic_error_24
        else 0

        this.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
    }
}