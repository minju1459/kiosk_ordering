package com.kiosk.app.blended

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.databinding.ItemBlendedMenuBinding
import com.kiosk.app.databinding.ItemEspressoMenuBinding

class BlendedAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<BlendedAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemBlendedMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.ivBlendedMenu.setImageResource(item.image)
            binding.tvBlendedName.text = item.name
            binding.tvBlendedPrice.text = item.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemBlendedMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}

data class Item(val image: Int, val name: String, val price: String)
