package com.kiosk.app.teabana

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentTeabanaBinding
import com.kiosk.app.util.binding.BindingFragment

class TeabanaFragment : BindingFragment<FragmentTeabanaBinding>(R.layout.fragment_teabana) {

    private val viewModel by viewModels<MainViewModel>()

    private var _adapter: TeabanaAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { "adapter_not_initialized_error_msg" }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTeabana.layoutManager = GridLayoutManager(context, 4)
        _adapter = TeabanaAdapter(viewModel)
        binding.rvTeabana.adapter = adapter
        val items = getItems()
        adapter.submitList(items)
    }

    private fun getItems(): List<Item> {
        return listOf(
            Item(R.drawable.ic_main_delete, "xlqkek 라떼", "3500원"),
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
