package com.kiosk.app.espresso

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentEspressoBinding
import com.kiosk.app.util.binding.BindingFragment

class EspressoFragment : BindingFragment<FragmentEspressoBinding>(R.layout.fragment_espresso) {

    private val viewModel by viewModels<MainViewModel>()

    private var _adapter: EspressoAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { "adapter_not_initialized_error_msg" }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvEspresso.layoutManager = GridLayoutManager(context, 4)
        _adapter = EspressoAdapter(viewModel)
        binding.rvEspresso.adapter = adapter
        val items = getItems()
        adapter.submitList(items)
    }

    private fun getItems(): List<Item> {
        return listOf(
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
            Item(R.drawable.img_green, "돌체 라떼", "3500원"),
            Item(R.drawable.img_green, "민주 라떼", "3500원"),
            Item(R.drawable.img_green, "안녕 라떼", "3500원"),
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
        )
    }
}
