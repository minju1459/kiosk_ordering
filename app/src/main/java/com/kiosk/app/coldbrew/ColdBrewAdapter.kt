package com.kiosk.app.coldbrew

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.databinding.ItemColdbrewMenuBinding

class BlendedAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<BlendedAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemColdbrewMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.ivColdbrewMenu.setImageResource(item.image)
            binding.tvColdbrewName.text = item.name
            binding.tvColdbrewPrice.text = item.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemColdbrewMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}

data class Item(val image: Int, val name: String, val price: String)
