package com.example.chiply.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chiply.R
import kotlinx.android.synthetic.main.product_info_layout.*

class ProductInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_info_layout)

        productInfoBack.setOnClickListener {
            finish()
        }
    }
}