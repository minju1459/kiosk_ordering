package com.kiosk.app.coldbrew

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.databinding.ItemColdbrewMenuBinding
import com.kiosk.app.util.DiffCallback

class ColdBrewAdapter(
    private val viewModel: MainViewModel,
) : ListAdapter<Item, ColdBrewAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemColdbrewMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount() = currentList.size

    class ViewHolder(private val binding: ItemColdbrewMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.ivColdbrewMenu.setImageResource(item.image)
            binding.tvColdbrewName.text = item.name
            binding.tvColdbrewPrice.text = item.price
        }
    }

    companion object {
        private val diffUtil = DiffCallback<Item>(
            onItemsTheSame = { old, new -> old == new }, // Assuming Item has an 'id' field
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
