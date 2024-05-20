package com.kiosk.app.espresso

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.databinding.ItemEspressoMenuBinding
import com.sopt.instagram.util.extension.setOnSingleClickListener

class EspressoAdapter(private val items: List<Item>, private val viewModel: MainViewModel) :
    RecyclerView.Adapter<EspressoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemEspressoMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class ViewHolder(
        private val binding: ItemEspressoMenuBinding,
        private val viewModel: MainViewModel,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.ivEspressoMenu.setImageResource(item.image)
            binding.tvEspressoName.text = item.name
            binding.tvEspressoPrice.text = item.price
            binding.layoutEspressoMenu.setOnSingleClickListener {
                viewModel.setSelectedItem(item)
            }
        }
    }
}
