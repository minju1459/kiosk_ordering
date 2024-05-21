package com.kiosk.app.blended

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.databinding.ItemBlendedMenuBinding
import com.kiosk.app.util.DiffCallback
import com.sopt.instagram.util.extension.setOnSingleClickListener

class BlendedAdapter(
    private val viewModel: MainViewModel,
    private val showDialog: () -> Unit,
) : ListAdapter<Item, BlendedAdapter.BlendedViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlendedViewHolder {
        val binding = ItemBlendedMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return BlendedViewHolder(binding, viewModel, showDialog)
    }

    override fun onBindViewHolder(holder: BlendedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun addItems(newItems: List<Item>) {
        val currentItems = currentList.toMutableList()
        currentItems.addAll(newItems)
        submitList(currentItems)
    }

    class BlendedViewHolder(
        private val binding: ItemBlendedMenuBinding,
        private val viewModel: MainViewModel,
        private val showDialog: () -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.ivBlendedMenu.setImageResource(item.image)
            binding.tvBlendedName.text = item.name
            binding.tvBlendedPrice.text = item.price
            binding.layoutBlendedMenu.setOnSingleClickListener {
                viewModel.setSelectedItem(item)
                showDialog()
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
