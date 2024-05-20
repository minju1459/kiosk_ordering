package com.kiosk.app.teabana

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.Item
import com.kiosk.app.databinding.ItemTeabanaMenuBinding

class TeabanaAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<TeabanaAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemTeabanaMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.ivTeabanaMenu.setImageResource(item.image)
            binding.tvTeabanaName.text = item.name
            binding.tvTeabanaPrice.text = item.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemTeabanaMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
