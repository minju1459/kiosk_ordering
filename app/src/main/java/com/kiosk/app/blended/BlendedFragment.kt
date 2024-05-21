package com.kiosk.app.blended

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentBlendedBinding
import com.kiosk.app.util.binding.BindingFragment

class BlendedFragment : BindingFragment<FragmentBlendedBinding>(R.layout.fragment_blended) {

    private val viewModel by viewModels<MainViewModel>()

    private var _adapter: BlendedAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { "adapter_not_initialized_error_msg" }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvBlended.layoutManager = GridLayoutManager(context, 4)
        _adapter = BlendedAdapter(viewModel)
        binding.rvBlended.adapter = adapter
        val items = getItems()
        adapter.submitList(items)
    }

    private fun getItems(): List<Item> {
        return listOf(
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "dkssud 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
        )
    }
}
