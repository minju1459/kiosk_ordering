import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kiosk.app.R

class EspressoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_espresso, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 4)
        recyclerView.adapter = EspressoAdater(getItems())

        return view
    }

    private fun getItems(): List<Item> {
        return listOf(
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),

            // 다른 아이템들 추가
        )
    }
}
