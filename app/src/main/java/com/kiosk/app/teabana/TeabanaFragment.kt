package com.kiosk.app.teabana

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.ItemDrink
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentTeabanaBinding
import com.kiosk.app.option.DialogDrinkOption
import com.kiosk.app.util.binding.BindingFragment

class TeabanaFragment : BindingFragment<FragmentTeabanaBinding>(R.layout.fragment_teabana) {

    private var _adapter: TeabanaAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTeabana.layoutManager = GridLayoutManager(context, 4)
        _adapter = TeabanaAdapter(::showDialogOption)
        binding.rvTeabana.adapter = adapter
        val items = getItems()
        adapter.submitList(items)
    }

    private fun showDialogOption(name: String, image: Int, basePrice: Int, count: Int) {
        val dialog = DialogDrinkOption()
        val bundle = Bundle().apply {
            putString("name", name)
            putInt("image", image)
            putInt("basePrice", basePrice)
            putInt("count", count)
        }
        dialog.arguments = bundle
        dialog.show(parentFragmentManager, "DialogDrinkOption")
    }

    private fun getItems(): List<ItemDrink> {
        return listOf(
            ItemDrink(R.drawable.img_hot_mint, "(HOT]민트 블렌드 티", 4700, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_ice_mint, "(ICE)민트 블렌드 티", 4700, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_ergray_tea, "(ICE)얼 그레이 티", 5400, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_useberry, "(ICE)유스베리 티", 5500, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_yuza, "(ICE)유자 민트 티", 6500, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_ice_english, "(ICE)잉글리쉬 브렉퍼스트 티", 4800, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_ergray_hot, "(HOT)얼 그레이 티", 5900, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_useberry, "(HOT)유스베리 티", 4900, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_hibiscus, "(HOT)히비스커스 블렌드 티", 4800, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_snow_malcha, "(ICE)스노우 말차 라떼", 5700, 1, "Tall Size", "", "", ""),
        )
    }
}
