package com.kiosk.app.espresso

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.Item
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentEspressoBinding
import com.kiosk.app.util.binding.BindingFragment

class EspressoFragment : BindingFragment<FragmentEspressoBinding>(R.layout.fragment_espresso) {

    private val viewModel by activityViewModels<MainViewModel>()

    private var _adapter: EspressoAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }
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
            Item(R.drawable.img_green, "(ICE)플랫 화이트", "3500원"),
            Item(R.drawable.img_green, "(HOT)플랫 화이트", "3500원"),
            Item(R.drawable.img_green, "(HOT)에스프레소 콘 파나", "3500원"),
            Item(R.drawable.img_green, "(HOT)에스프레소 마키아또", "3500원"),
            Item(R.drawable.img_green, "(ICE)카페 아메리카노", "3500원"),
            Item(R.drawable.img_green, "(HOT)카페 아메리카노", "3500원"),
            Item(R.drawable.img_green, "(ICE)카라멜 마키아또", "3500원"),
            Item(R.drawable.img_green, "(HOT)카라멜 마키아또", "3500원"),
            Item(R.drawable.img_green, "(ICE)카푸치노", "3500원"),
            Item(R.drawable.img_green, "(HOT)카푸치노", "3500원"),
            Item(R.drawable.img_green, "(ICE)라벤더 카페 브레베", "3500원"),
            Item(R.drawable.img_green, "(ICE)바닐라빈 라떼", "3500원"),
            Item(R.drawable.img_green, "(ICE)사케라또 비안코 오버", "3500원"),
            Item(R.drawable.img_green, "(ICE)스타벅스 1호점 카페 라떼", "3500원"),
            Item(R.drawable.img_green, "(ICE)스타벅스 돌체 라떼", "3500원"),
            Item(R.drawable.img_green, "(ICE)카페 라떼", "3500원"),
            Item(R.drawable.img_green, "(HOT)카페 라떼", "3500원"),
            Item(R.drawable.img_green, "(ICE)카페 모카", "3500원"),
            Item(R.drawable.img_green, "(ICE)화이트 초콜릿 모카", "3500원"),
            Item(R.drawable.img_green, "(ICE)바닐라 스타벅스 더블 샷", "3500원"),

            //TODO : 메뉴 추후에 또 추가 에정

        )
    }
}
