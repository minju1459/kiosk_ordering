import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.R

class EspressoAdater(private val items: List<Item>) :
    RecyclerView.Adapter<EspressoAdater.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.lyj_strawLatte_img)
        val nameTextView: TextView = itemView.findViewById(R.id.lyj_strawLatte_text)
        val priceTextView: TextView = itemView.findViewById(R.id.lyj_strawLatte_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.nameTextView.text = item.name
        holder.priceTextView.text = item.price
    }

    override fun getItemCount() = items.size
}

data class Item(val imageResId: Int, val name: String, val price: String)
