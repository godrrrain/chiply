package com.example.chiply.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chiply.domain.model.Product
import com.example.chiply.R
import kotlinx.android.synthetic.main.item_cart.view.*

class CartAdapter(
        private val onDeleteClick: (product: Product) -> Unit
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    private var cart: List<Product> = listOf()

    fun setData(data: List<Product>) {
        cart = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.ViewHolder =
            ViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
            )

    override fun onBindViewHolder(holder: CartAdapter.ViewHolder, position: Int) {
        holder.bind(cart[position])
    }

    override fun getItemCount(): Int = cart.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(product: Product) {
            itemView.cartProductNameTv.text = product.getName()
            itemView.cartProductPriceValue.text = "${product.calcDiscountPrice()} руб"
            itemView.cartProductDiscountValue.text = "скидка ${product.getDiscount()}%"

            itemView.cartDeleteIv.setOnClickListener {
                onDeleteClick(product)
            }
        }
    }
}