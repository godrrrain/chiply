package com.example.chiply.data

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.chiply.domain.ViewedProductDao

class ViewedProductDaoImpl(
        private val sharedPreferences: SharedPreferences
) : ViewedProductDao {


    private var savedProductIds: List<Int>
        get() = sharedPreferences.getString(PRODUCT_TAG, null)
                ?.split(",")
                ?.mapNotNull { it.toIntOrNull() } ?: emptyList()
        set(value) {
            sharedPreferences.edit {
                putString(PRODUCT_TAG, value.joinToString(","))
            }
        }

    override fun addProduct(productId: Int) {
        val productIds: List<Int> = savedProductIds
        val newProductIds = mutableListOf<Int>().apply {
            add(productId)
            addAll(productIds.filter { it != productId })
        }
        savedProductIds = newProductIds
    }

    override fun getAllProducts(): List<Int> {
        return savedProductIds
    }

    companion object {
        private const val PRODUCT_TAG = "PRODUCT_TAG"
    }
}