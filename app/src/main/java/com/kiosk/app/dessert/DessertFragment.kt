package com.kiosk.app.dessert

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentDessertBinding
import com.kiosk.app.option.DialogHeatOption
import com.kiosk.app.util.binding.BindingFragment

class DessertFragment : BindingFragment<FragmentDessertBinding>(R.layout.fragment_dessert) {

    private val viewModel by activityViewModels<MainViewModel>()

    private var _adapter: DessertAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvDessert.layoutManager = GridLayoutManager(context, 4)
        _adapter = DessertAdapter(viewModel, ::showDialog)
        binding.rvDessert.adapter = adapter
        val items = getItems()
        adapter.submitList(items)
    }

    private fun showDialog() {
        val dialog = DialogHeatOption()
        dialog.show(parentFragmentManager, "DialogHeatOption")
    }

    private fun getItems(): List<Item> {
        return listOf(
            Item(R.drawable.ic_main_delete, "g기 라떼", 3500, 1),
            Item(R.drawable.ic_main_delete, "딸기 라떼", 3500, 1),
            Item(R.drawable.ic_main_delete, "딸기 라떼", 3500, 1),
            Item(R.drawable.ic_main_delete, "딸기 라떼", 3500, 1),
            Item(R.drawable.ic_main_delete, "딸기 라떼", 3500, 1),
            Item(R.drawable.ic_main_delete, "딸기 라떼", 3500, 1),
            Item(R.drawable.ic_main_delete, "딸기 라떼", 3500, 1),
            Item(R.drawable.ic_main_delete, "딸기 라떼", 3500, 1),
            Item(R.drawable.ic_main_delete, "딸기 라떼", 3500, 1),
            Item(R.drawable.ic_main_delete, "딸기 라떼", 3500, 1),
            Item(R.drawable.ic_main_delete, "딸기 라떼", 3500, 1),
        )
    }
}
