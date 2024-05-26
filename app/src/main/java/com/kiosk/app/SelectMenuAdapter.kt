package com.kiosk.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.databinding.ItemSelectMenuBinding
import com.kiosk.app.option.DialogDrinkOption
import com.sopt.instagram.util.extension.setOnSingleClickListener

class SelectMenuAdapter(
    private val viewModel: MainViewModel,
    private val fragmentManager: FragmentManager
) : RecyclerView.Adapter<SelectMenuAdapter.SelectMenuViewHolder>() {

    private val items: MutableList<ItemDrink> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectMenuViewHolder {
        val binding =
            ItemSelectMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectMenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectMenuViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun addItem(item: ItemDrink) {
        items.add(item)
        notifyItemInserted(items.size - 1)
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

        fun bind(item: ItemDrink) {
            with(binding) {
                tvSelectMenu.text = item.name
                tvMenuPrice.text = item.price.toString()
                tvMenuCount.text = item.count.toString()
                tvSize.text = item.size
                tvShot.text = item.shot
                tvSyrub.text = item.syrub
                tvCream.text = item.cream
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
                layoutSelectMenu.setOnSingleClickListener {
                    showDialog(item)
                    removeItem(adapterPosition)
                }
            }
        }

        private fun showDialog(item: ItemDrink) {
            val dialog = DialogDrinkOption().apply {
                arguments = Bundle().apply {
                    putInt("image", item.image)
                    putString("name", item.name)
                    putInt("count", item.count)
                    putInt("basePrice", item.price)
                }
            }
            dialog.show(fragmentManager, "DialogDrinkOption")
        }
    }
}
