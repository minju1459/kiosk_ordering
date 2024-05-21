package com.kiosk.app.coldbrew

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.databinding.ItemColdbrewMenuBinding
import com.kiosk.app.util.DiffCallback
import com.sopt.instagram.util.extension.setOnSingleClickListener

class ColdBrewAdapter(
    private val viewModel: MainViewModel,
    private val showDialog: () -> Unit,
) : ListAdapter<Item, ColdBrewAdapter.ColdBrewViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColdBrewViewHolder {
        val binding = ItemColdbrewMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return ColdBrewViewHolder(binding, viewModel, showDialog)
    }

    override fun onBindViewHolder(holder: ColdBrewViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun addItems(newItems: List<Item>) {
        val currentItems = currentList.toMutableList()
        currentItems.addAll(newItems)
        submitList(currentItems)
    }

    override fun getItemCount() = currentList.size

    class ColdBrewViewHolder(
        private val binding: ItemColdbrewMenuBinding,
        private val viewModel: MainViewModel,
        private val showDialog: () -> Unit,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.ivColdbrewMenu.setImageResource(item.image)
            binding.tvColdbrewName.text = item.name
            binding.tvColdbrewPrice.text = item.price
            binding.layoutColdbrewMenu.setOnSingleClickListener {
                viewModel.setSelectedItem(item)
                showDialog()
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
