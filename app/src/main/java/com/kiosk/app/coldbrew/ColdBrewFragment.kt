package com.kiosk.app.coldbrew

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentColdbrewBinding
import com.kiosk.app.option.DialogIceOption
import com.kiosk.app.util.binding.BindingFragment

class ColdBrewFragment : BindingFragment<FragmentColdbrewBinding>(R.layout.fragment_coldbrew) {
    private val viewModel by activityViewModels<MainViewModel>()

    private var _adapter: ColdBrewAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvColdbrew.layoutManager = GridLayoutManager(context, 4)
        _adapter = ColdBrewAdapter(viewModel, ::showDialog)
        binding.rvColdbrew.adapter = adapter
        val items = getItems()
        adapter.submitList(items)
    }

    private fun showDialog() {
        val dialog = DialogIceOption()
        dialog.show(parentFragmentManager, "DialogIceOption")
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
        )
    }
}
