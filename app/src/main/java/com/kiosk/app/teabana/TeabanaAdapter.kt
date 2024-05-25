package com.kiosk.app.teabana

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.Item
import com.kiosk.app.databinding.ItemTeabanaMenuBinding
import com.kiosk.app.util.DiffCallback
import com.sopt.instagram.util.extension.setOnSingleClickListener

class TeabanaAdapter(
    private val showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
) : ListAdapter<Item, TeabanaAdapter.TeabanaViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeabanaViewHolder {
        val binding = ItemTeabanaMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return TeabanaViewHolder(binding, showDialog)
    }

    override fun onBindViewHolder(holder: TeabanaViewHolder, position: Int) {
        holder.bind(getItem(position), showDialog)
    }

    class TeabanaViewHolder(
        private val binding: ItemTeabanaMenuBinding,
        private val showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item, showDialog: (name: String, image: Int, basePrice: Int, count: Int) -> Unit) {
            with(binding) {
                ivTeabanaMenu.setImageResource(item.image)
                tvTeabanaName.text = item.name
                tvTeabanaPrice.text = item.price.toString()
                layoutTeabanaMenu.setOnSingleClickListener {
                    showDialog(item.name, item.image, item.basePrice, item.count)
                }
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
