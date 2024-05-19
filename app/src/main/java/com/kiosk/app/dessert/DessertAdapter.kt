package com.kiosk.app.dessert

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.databinding.ItemDessertMenuBinding

class DessertAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<DessertAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemDessertMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.ivDessertMenu.setImageResource(item.image)
            binding.tvDessertName.text = item.name
            binding.tvDessertPrice.text = item.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemDessertMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}

data class Item(val image: Int, val name: String, val price: String)
