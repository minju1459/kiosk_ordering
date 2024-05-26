package com.kiosk.app.espresso

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.ItemDrink
import com.kiosk.app.databinding.ItemEspressoMenuBinding
import com.kiosk.app.util.DiffCallback
import com.sopt.instagram.util.extension.setOnSingleClickListener

class EspressoAdapter(
    private val showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
) : ListAdapter<ItemDrink, EspressoAdapter.EspressoViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EspressoViewHolder {
        val binding = ItemEspressoMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return EspressoViewHolder(binding, showDialog)
    }

    override fun onBindViewHolder(holder: EspressoViewHolder, position: Int) {
        holder.bind(getItem(position), showDialog)
    }

    class EspressoViewHolder(
        private val binding: ItemEspressoMenuBinding,
        private val showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemDrink, showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit) {
            binding.ivEspressoMenu.setImageResource(item.image)
            binding.tvEspressoName.text = item.name
            binding.tvEspressoPrice.text = item.price.toString()
            binding.layoutEspressoMenu.setOnSingleClickListener {
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
