import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.Item
import com.kiosk.app.databinding.ItemSelectMenuBinding

class SelectMenuAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<SelectMenuAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemSelectMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.tvSelectMenu.text = item.name
            binding.tvMenuPrice.text = item.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemSelectMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
