package com.kiosk.app.Frappuccino

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.ItemDrink
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentFrappuccinoBinding
import com.kiosk.app.DialogDrinkOption
import com.kiosk.app.util.binding.BindingFragment

class FrappuccinoFragment :
    BindingFragment<FragmentFrappuccinoBinding>(R.layout.fragment_frappuccino) {

    private var _adapter: FrappuccinoAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvDessert.layoutManager = GridLayoutManager(context, 4)
        _adapter = FrappuccinoAdapter(::showDialog)
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

    private fun getItems(): List<ItemDrink> {
        return listOf(
            ItemDrink(R.drawable.img_espresso_fra, "에스프레소 프라푸치노", 5500, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_java_fra, "자바 칩 프라푸치노", 6800, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_caramel_fra, "카라멜 프라푸치노", 6500, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_white_choco_fra, "화이트 초콜릿 모카 프라푸치노", 6500, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_jeju_fra, "제주 까망 크림 프라푸치노", 5700, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_malcha_fra, "제주 말차 크림 프라푸치노", 5900, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_ssuk_fra, "제주 쑥덕 크림 프라푸치노", 5300, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_choco_fra, "초콜릿 크림 칩 프라푸치노", 5600, 1, "Tall Size", "", "", ""),
            ItemDrink(R.drawable.img_tiger_fra, "화이트 타이거 프라푸치노", 6400, 1, "Tall Size", "", "", ""),
        )
    }
}
