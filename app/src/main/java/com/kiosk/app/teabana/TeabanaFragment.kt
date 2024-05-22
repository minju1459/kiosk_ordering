package com.kiosk.app.teabana

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentTeabanaBinding
import com.kiosk.app.option.DialogHotOption
import com.kiosk.app.option.DialogIceOption
import com.kiosk.app.util.binding.BindingFragment

class TeabanaFragment : BindingFragment<FragmentTeabanaBinding>(R.layout.fragment_teabana) {

    private val viewModel by activityViewModels<MainViewModel>()

    private var _adapter: TeabanaAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTeabana.layoutManager = GridLayoutManager(context, 4)
        _adapter = TeabanaAdapter(viewModel) { item -> onItemClicked(item) }
        binding.rvTeabana.adapter = adapter
        val items = getItems()
        adapter.submitList(items)
    }

    private fun onItemClicked(item: Item) {
        if (item.name.contains("ICE")) {
            showDialogIceOption()
        } else if (item.name.contains("HOT")) {
            showDialogHotOption()
        }
    }

    private fun showDialogIceOption() {
        val dialog = DialogIceOption()
        dialog.show(parentFragmentManager, "DialogIceOption")
    }

    private fun showDialogHotOption() {
        val dialog = DialogHotOption()
        dialog.show(parentFragmentManager, "DialogHotOption")
    }

    private fun getItems(): List<Item> {
        return listOf(
            Item(R.drawable.img_hot_mint, "(HOT]민트 블렌드 티", 4700, 1, "Tall Size", false, false, false),
            Item(R.drawable.img_ice_mint, "(ICE)민트 블렌드 티", 4700, 1, "Tall Size", false, false, false),
            Item(R.drawable.img_ergray_tea, "(ICE)얼 그레이 티", 5400, 1, "Tall Size", false, false, false),
            Item(R.drawable.img_useberry, "(ICE)유스베리 티", 5500, 1, "Tall Size", false, false, false),
            Item(R.drawable.img_yuza, "(ICE)유자 민트 티", 6500, 1, "Tall Size", false, false, false),
            Item(R.drawable.img_ice_english, "(ICE)잉글리쉬 브렉퍼스트 티", 4800, 1, "Tall Size", false, false, false),
            Item(R.drawable.img_ergray_hot, "(HOT)얼 그레이 티", 5900, 1, "Tall Size", false, false, false),
            Item(R.drawable.img_useberry, "(HOT)유스베리 티", 4900, 1, "Tall Size", false, false, false),
            Item(R.drawable.img_hibiscus, "(HOT)히비스커스 블렌드 티", 4800, 1, "Tall Size", false, false, false),
            Item(R.drawable.img_snow_malcha, "(ICE)스노우 말차 라떼", 5700, 1, "Tall Size", false, false, false),
        )
    }
}
