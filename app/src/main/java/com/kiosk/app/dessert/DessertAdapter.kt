package com.kiosk.app.dessert

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.Item
import com.kiosk.app.databinding.ItemDessertMenuBinding
import com.kiosk.app.util.DiffCallback
import com.sopt.instagram.util.extension.setOnSingleClickListener

class DessertAdapter(
    private val showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
) : ListAdapter<Item, DessertAdapter.DessertViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DessertViewHolder {
        val binding = ItemDessertMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return DessertViewHolder(binding, showDialog)
    }

    override fun onBindViewHolder(holder: DessertViewHolder, position: Int) {
        holder.bind(getItem(position), showDialog)
    }

    class DessertViewHolder(
        private val binding: ItemDessertMenuBinding,
        private val showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: Item,
            showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
        ) {
            binding.ivDessertMenu.setImageResource(item.image)
            binding.tvDessertName.text = item.name
            binding.tvDessertPrice.text = item.price.toString()
            binding.layoutDessertMenu.setOnSingleClickListener {
                showDialog(item.name, item.image, item.basePrice, item.count)
            }
        }
    }

    companion object {
        private val diffUtil = DiffCallback<Item>(
            onItemsTheSame = { old, new -> old == new },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
