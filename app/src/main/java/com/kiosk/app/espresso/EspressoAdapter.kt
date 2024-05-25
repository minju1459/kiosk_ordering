package com.kiosk.app.espresso

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.Item
import com.kiosk.app.databinding.ItemEspressoMenuBinding
import com.kiosk.app.util.DiffCallback
import com.sopt.instagram.util.extension.setOnSingleClickListener

class EspressoAdapter(
    private val showDialog: (name: String, image: Int) -> Unit,
) : ListAdapter<Item, EspressoAdapter.EspressoViewHolder>(diffUtil) {

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
        private val showDialog: (name: String, price: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item, showDialog: (name: String, image: Int) -> Unit) {
            binding.ivEspressoMenu.setImageResource(item.image)
            binding.tvEspressoName.text = item.name
            binding.tvEspressoPrice.text = item.price.toString()
            binding.layoutEspressoMenu.setOnSingleClickListener {
                showDialog(item.name, item.image)
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
