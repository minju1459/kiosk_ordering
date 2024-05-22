package com.kiosk.app.teabana

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.databinding.ItemTeabanaMenuBinding
import com.kiosk.app.util.DiffCallback
import com.sopt.instagram.util.extension.setOnSingleClickListener

class TeabanaAdapter(
    private val viewModel: MainViewModel,
    private val showDialog: (Item) -> Unit,
) : ListAdapter<Item, TeabanaAdapter.TeabanaViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeabanaViewHolder {
        val binding = ItemTeabanaMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return TeabanaViewHolder(binding, viewModel, showDialog)
    }

    override fun onBindViewHolder(holder: TeabanaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun addItems(newItems: List<Item>) {
        val currentItems = currentList.toMutableList()
        currentItems.addAll(newItems)
        submitList(currentItems)
    }

    class TeabanaViewHolder(
        private val binding: ItemTeabanaMenuBinding,
        private val viewModel: MainViewModel,
        private val showDialog: (Item) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.ivTeabanaMenu.setImageResource(item.image)
            binding.tvTeabanaName.text = item.name
            binding.tvTeabanaPrice.text = item.price.toString()
            binding.layoutTeabanaMenu.setOnSingleClickListener {
                viewModel.setSelectedItem(item)
                showDialog(item)
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
