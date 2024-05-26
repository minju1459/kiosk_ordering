package com.kiosk.app.coldbrew

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.ItemDrink
import com.kiosk.app.databinding.ItemColdbrewMenuBinding
import com.kiosk.app.util.DiffCallback
import com.sopt.instagram.util.extension.setOnSingleClickListener

class ColdBrewAdapter(
    private val showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
) : ListAdapter<ItemDrink, ColdBrewAdapter.ColdBrewViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColdBrewViewHolder {
        val binding = ItemColdbrewMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return ColdBrewViewHolder(binding, showDialog)
    }

    override fun onBindViewHolder(holder: ColdBrewViewHolder, position: Int) {
        holder.bind(getItem(position), showDialog)
    }

    override fun getItemCount() = currentList.size

    class ColdBrewViewHolder(
        private val binding: ItemColdbrewMenuBinding,
        private val showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: ItemDrink,
            showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
        ) {
            binding.ivColdbrewMenu.setImageResource(item.image)
            binding.tvColdbrewName.text = item.name
            binding.tvColdbrewPrice.text = item.price.toString()
            binding.layoutColdbrewMenu.setOnSingleClickListener {
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
