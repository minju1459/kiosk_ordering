package com.kiosk.app.dessert

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentDessertBinding
import com.kiosk.app.option.DialogDrinkOption
import com.kiosk.app.util.binding.BindingFragment

class DessertFragment : BindingFragment<FragmentDessertBinding>(R.layout.fragment_dessert) {

    private val viewModel by activityViewModels<MainViewModel>()

    private var _adapter: DessertAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvDessert.layoutManager = GridLayoutManager(context, 4)
        _adapter = DessertAdapter(::showDialog)
        binding.rvDessert.adapter = adapter
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

    private fun getItems(): List<Item> {
        return listOf(
            Item(R.drawable.img_sosage, "소시지 프레첼 소금빵", 4500, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_tomato, "바질 토마토 크림치즈 베이글", 6800, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_bluberry, "탕종 블루베리 베이글", 6500, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_plain_bagle, "탕종 플레인 베이글", 5700, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_mini, "미니 클래식 스콘", 5900, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_scon, "클래식 스콘", 4300, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_ssuk, "피넛 쑥 떡 스콘", 5600, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_leef_pie, "미니 리프 파이", 6400, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_bazzil, "바질 치즈 포카치아", 6200, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_oh_shocola, "뺑 오 쇼콜라", 5700, 1, "Tall Size", "", "", ""),
        )
    }
}
