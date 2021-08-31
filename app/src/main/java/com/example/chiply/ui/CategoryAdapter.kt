package com.example.chiply.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chiply.R
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var categories: List<String> = listOf()

    fun setData(data: List<String>) {
        categories = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder =
            ViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
            )

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(text: String) {
            itemView.categoryTv.text = text
        }
    }
}