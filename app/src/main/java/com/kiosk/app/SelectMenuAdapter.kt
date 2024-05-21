import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.Item
import com.kiosk.app.databinding.ItemSelectMenuBinding
import com.kiosk.app.util.DiffCallback

class SelectMenuAdapter : ListAdapter<Item, SelectMenuAdapter.SelectMenuViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectMenuViewHolder {
        val binding = ItemSelectMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectMenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectMenuViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun addItems(newItems: List<Item>) {
        val currentItems = currentList.toMutableList()
        currentItems.addAll(newItems)
        submitList(currentItems)
    }

    class SelectMenuViewHolder(
        private val binding: ItemSelectMenuBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.tvSelectMenu.text = item.name
            binding.tvMenuPrice.text = item.price
        }
    }

    companion object {
        private val diffUtil = DiffCallback<Item>(
            onItemsTheSame = { old, new -> old == new },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
