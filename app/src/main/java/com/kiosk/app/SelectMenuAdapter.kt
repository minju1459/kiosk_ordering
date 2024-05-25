package com.kiosk.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.databinding.ItemSelectMenuBinding
import com.sopt.instagram.util.extension.setOnSingleClickListener

class SelectMenuAdapter(private val viewModel: MainViewModel) :
    RecyclerView.Adapter<SelectMenuAdapter.SelectMenuViewHolder>() {

    private val items: MutableList<Item> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectMenuViewHolder {
        val binding = ItemSelectMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectMenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectMenuViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun addItems(newItems: List<Item>) {
        items.addAll(newItems)
        notifyDataSetChanged()
        updateTotal()
    }

    private fun updateItemCount(position: Int, newCount: Int) {
        if (position in items.indices) {
            val updatedItem = items[position].copy(count = newCount)
            items[position] = updatedItem
            notifyItemChanged(position)
            updateTotal()
        }
    }

    private fun removeItem(position: Int) {
        if (position in items.indices) {
            items.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, items.size)
            updateTotal()
        }
    }

    private fun updateTotal() {
        viewModel.updateTotal(items)
    }

    inner class SelectMenuViewHolder(
        private val binding: ItemSelectMenuBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            with(binding) {
                tvSelectMenu.text = item.name
                tvMenuPrice.text = item.price.toString()
                tvMenuCount.text = item.count.toString()
                btnPlus.setOnSingleClickListener {
                    updateItemCount(adapterPosition, item.count + 1)
                }
                btnMinus.setOnSingleClickListener {
                    if (item.count > 1) {
                        updateItemCount(adapterPosition, item.count - 1)
                    }
                }
                btnDeleteMenu.setOnSingleClickListener {
                    removeItem(adapterPosition)
                }
            }
        }
    }
}
