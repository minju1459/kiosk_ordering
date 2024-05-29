package com.kiosk.app.Frappuccino

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.ItemDrink
import com.kiosk.app.databinding.ItemFrappuccinoMenuBinding
import com.kiosk.app.util.DiffCallback
import com.sopt.instagram.util.extension.setOnSingleClickListener

class FrappuccinoAdapter(
    private val showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
) : ListAdapter<ItemDrink, FrappuccinoAdapter.DessertViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DessertViewHolder {
        val binding = ItemFrappuccinoMenuBinding.inflate(
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
        private val binding: ItemFrappuccinoMenuBinding,
        private val showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: ItemDrink,
            showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
        ) {
            binding.ivFrappuccinoMenu.setImageResource(item.image)
            binding.tvFrappuccinoName.text = item.name
            binding.tvFrappuccinoPrice.text = item.price.toString()
            binding.layoutFrappuccinoMenu.setOnSingleClickListener {
                showDialog(item.name, item.image, item.basePrice, item.count)
            }
        }
    }

    companion object {
        private val diffUtil = DiffCallback<ItemDrink>(
            onItemsTheSame = { old, new -> old == new },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
