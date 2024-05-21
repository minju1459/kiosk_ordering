package com.kiosk.app.espresso

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.databinding.ItemEspressoMenuBinding
import com.kiosk.app.util.DiffCallback
import com.sopt.instagram.util.extension.setOnSingleClickListener

class EspressoAdapter(
    private val viewModel: MainViewModel,
    private val showDialog: (Item) -> Unit,
) : ListAdapter<Item, EspressoAdapter.EspressoViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EspressoViewHolder {
        val binding = ItemEspressoMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return EspressoViewHolder(binding, viewModel, showDialog)
    }

    override fun onBindViewHolder(holder: EspressoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun addItems(newItems: List<Item>) {
        val currentItems = currentList.toMutableList()
        currentItems.addAll(newItems)
        submitList(currentItems)
    }

    class EspressoViewHolder(
        private val binding: ItemEspressoMenuBinding,
        private val viewModel: MainViewModel,
        private val showDialog: (Item) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.ivEspressoMenu.setImageResource(item.image)
            binding.tvEspressoName.text = item.name
            binding.tvEspressoPrice.text = item.price
            binding.layoutEspressoMenu.setOnSingleClickListener {
                viewModel.setSelectedItem(item)
                showDialog(item) // 클릭한 아이템을 showDialog 함수에 전달
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
