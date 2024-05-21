package com.kiosk.app.dessert

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.databinding.ItemDessertMenuBinding
import com.kiosk.app.util.DiffCallback
import com.sopt.instagram.util.extension.setOnSingleClickListener

class DessertAdapter(
    private val viewModel: MainViewModel,
) : ListAdapter<Item, DessertAdapter.DessertViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DessertViewHolder {
        val binding =
            ItemDessertMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DessertViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: DessertViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun addItems(newItems: List<Item>) {
        val currentItems = currentList.toMutableList()
        currentItems.addAll(newItems)
        submitList(currentItems)
    }

    class DessertViewHolder(
        private val binding: ItemDessertMenuBinding,
        private val viewModel: MainViewModel,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.ivDessertMenu.setImageResource(item.image)
            binding.tvDessertName.text = item.name
            binding.tvDessertPrice.text = item.price
            binding.layoutDessertMenu.setOnSingleClickListener {
                viewModel.setSelectedItem(item)
            }
        }
    }

        companion object {
            private val diffUtil = DiffCallback<Item>(
                onItemsTheSame = { old, new -> old == new }, // Assuming Item has an 'id' field
                onContentsTheSame = { old, new -> old == new },
            )
        }
    }

