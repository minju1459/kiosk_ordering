package com.kiosk.app.blended

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.ItemDrink
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentBlendedBinding
import com.kiosk.app.option.DialogDrinkOption
import com.kiosk.app.util.binding.BindingFragment

class BlendedFragment : BindingFragment<FragmentBlendedBinding>(R.layout.fragment_blended) {

    private var _adapter: BlendedAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvBlended.layoutManager = GridLayoutManager(context, 4)
        _adapter = BlendedAdapter(::showDialog)
        binding.rvBlended.adapter = adapter
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
            ItemDrink(R.drawable.img_double_lemon, "더블 레몬 블렌디드", 6700, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_mango_fashion, "망고 패션 티 블렌디드", 7500, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_lemon_ergray, "북한산 레몬 얼 그레이 블렌디드", 6700, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_classic_milk, "클래식 밀크티 블렌디드", 6700, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_yeosu_bada, "여수 바다 유자 블렌디드", 6900, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_delight, "딸기 딜라이트 요거트 블렌디드", 6500, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_mango, "망고 바나나 블렌디드", 6400, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_sky, "코튼 스카이 요거트 블렌디드", 7900, 1, "Tall Size", "", "", ""),
        )
    }
}
