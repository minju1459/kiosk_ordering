package com.kiosk.app.blended

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.ItemDrink
import com.kiosk.app.databinding.ItemBlendedMenuBinding
import com.kiosk.app.util.DiffCallback
import com.sopt.instagram.util.extension.setOnSingleClickListener

class BlendedAdapter(
    private val showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
) : ListAdapter<ItemDrink, BlendedAdapter.BlendedViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlendedViewHolder {
        val binding = ItemBlendedMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return BlendedViewHolder(binding, showDialog)
    }

    override fun onBindViewHolder(holder: BlendedViewHolder, position: Int) {
        holder.bind(getItem(position), showDialog)
    }

    class BlendedViewHolder(
        private val binding: ItemBlendedMenuBinding,
        private val showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemDrink, showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit) {
            binding.ivBlendedMenu.setImageResource(item.image)
            binding.tvBlendedName.text = item.name
            binding.tvBlendedPrice.text = item.price.toString()
            binding.layoutBlendedMenu.setOnSingleClickListener {
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
