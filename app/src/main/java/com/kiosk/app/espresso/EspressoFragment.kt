package com.kiosk.app.espresso

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentEspressoBinding
import com.kiosk.app.option.DialogDrinkOption
import com.kiosk.app.util.binding.BindingFragment

class EspressoFragment : BindingFragment<FragmentEspressoBinding>(R.layout.fragment_espresso) {

    private val viewModel by activityViewModels<MainViewModel>()

    private var _adapter: EspressoAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvEspresso.layoutManager = GridLayoutManager(context, 4)
        _adapter = EspressoAdapter(::showDialogOption)
        binding.rvEspresso.adapter = adapter
        val items = getItems()
        adapter.submitList(items)
    }

    private fun showDialogOption(name: String, image: Int) {
        val dialog = DialogDrinkOption()
        val bundle = Bundle().apply {
            putString("name", name)
            putInt("image", image)
        }
        dialog.arguments = bundle
        dialog.show(parentFragmentManager, "DialogDrinkOption")
    }
    private fun getItems(): List<Item> {
        return listOf(
            Item(R.drawable.img_ice_flat_white, "(ICE)플랫 화이트", 5600, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_hot_flat_white, "(HOT)플랫 화이트", 5600, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_espresso_conpana, "(ICE)에스프레소 콘 파나", 4200, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_espresso_machiaddo, "(HOT)에스프레소 마키아또", 4000, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_ice_americano, "(ICE)카페 아메리카노", 4500, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_hot_americano, "(HOT)카페 아메리카노", 4500, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_ice_caramel, "(ICE)카라멜 마키아또", 5900, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_hot_caramel, "(HOT)카라멜 마키아또", 5900, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_ice_cappuchino, "(ICE)카푸치노", 5000, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_hot_cappuchino, "(HOT)카푸치노", 5000, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_ice_vanilla_bean, "(ICE)바닐라빈 라떼", 5900, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_ice_sacheraddo, "(ICE)사케라또 비안코 오버", 6000, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_hot_ilho, "(HOT)스타벅스 1호점 카페 라떼", 6500, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_hot_dolche_latte, "(HOT)스타벅스 돌체 라떼", 5900, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_ice_cafe_latte, "(ICE)카페 라떼", 5000, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_hot_cafe_latte, "(HOT)카페 라떼", 5000, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_ice_caffe_mocha, "(ICE)카페 모카", 5500, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_ice_white_chocolate, "(ICE)화이트 초콜릿 모카", 5900, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_ice_vanilla_double_shot, "(ICE)바닐라 스타벅스 더블 샷", 5100, 1, "Tall Size", "", "", ""),
            Item(R.drawable.img_ice_classic_apogato, "(ICE)클래식 아포가토", 5700, 1, "Tall Size", "", "", ""),
        )
    }
}
