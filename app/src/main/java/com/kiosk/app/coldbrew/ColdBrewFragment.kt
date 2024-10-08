package com.kiosk.app.coldbrew

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.ItemDrink
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentColdbrewBinding
import com.kiosk.app.DialogDrinkOption
import com.kiosk.app.util.binding.BindingFragment

class ColdBrewFragment : BindingFragment<FragmentColdbrewBinding>(R.layout.fragment_coldbrew) {
    private val viewModel by activityViewModels<MainViewModel>()

    private var _adapter: ColdBrewAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvColdbrew.layoutManager = GridLayoutManager(context, 4)
        _adapter = ColdBrewAdapter(::showDialog)
        binding.rvColdbrew.adapter = adapter
        val items = getItems()
        adapter.submitList(items)
    }

    private fun showDialog(name: String, image: Int, basePrice: Int, count: Int) {
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
            ItemDrink(R.drawable.img_cold_brew, "(ICE)콜드 브루", 4900, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_ot_cold, "(ICE)오트 콜드 브루", 5800, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_dolche_cold, "(ICE)돌체 콜드 브루", 6000, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_vanilla_cold, "(ICE)바닐라 크림 콜드 브루", 5800, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_nitro_vanilla, "(ICE)나이트로 바닐라 크림", 6100, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_nitro, "(ICE)나이트로 콜드 브루", 6000, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_jeju, "(ICE)제주 비자림 콜드 브루", 6800, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_yeosu, "(ICE)여수 윤슬 헤이즐넛", 7500, 1, "Tall Size", "", "", ""),
        )
    }
}
