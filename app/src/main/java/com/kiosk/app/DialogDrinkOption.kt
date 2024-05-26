package com.kiosk.app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.kiosk.app.databinding.DialogDrinkOptionBinding
import com.kiosk.app.util.binding.BindingDialogFragment
import com.sopt.instagram.util.extension.setOnSingleClickListener

class DialogDrinkOption :
    BindingDialogFragment<DialogDrinkOptionBinding>(R.layout.dialog_drink_option) {

    private val viewModel by activityViewModels<MainViewModel>()

    private val image by lazy { arguments?.getInt("image", 0) ?: 0 }
    private val name by lazy { arguments?.getString("name", "") ?: "" }
    private val count by lazy { arguments?.getInt("count", 0) ?: 0 }
    private val basePrice by lazy { arguments?.getInt("basePrice", 0) ?: 0 }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            ivMenuImage.setImageResource(image)
            tvMenuName.text = name
            btnOptionQuit.setOnSingleClickListener {
                val item = ItemDrink(
                    image = image,
                    name = name,
                    basePrice = basePrice,
                    count = count,
                    size = getSelectedSize(),
                    shot = getSelectedShot(),
                    syrub = getSelectedSyrup(),
                    cream = getSelectedCream(),
                )
                viewModel.setSelectedItem(item)
                dismiss()
            }
        }
    }

    private fun getSelectedSize() = when (binding.rgSize.checkedRadioButtonId) {
        R.id.rb_tall_size -> "Tall Size"
        R.id.rb_grande_size -> "Grande Size"
        R.id.rb_venti_size -> "Venti Size"
        else -> ""
    }

    private fun getSelectedShot() = when (binding.rgShot.checkedRadioButtonId) {
        R.id.rb_shot_none -> "없음"
        R.id.rb_shot_1 -> "1샷"
        R.id.rb_shot_2 -> "2샷"
        R.id.rb_shot_3 -> "3샷"
        else -> ""
    }

    private fun getSelectedSyrup() = when (binding.rgSyrub.checkedRadioButtonId) {
        R.id.rb_syrup_none -> "없음"
        R.id.rb_syrup_1 -> "1번"
        R.id.rb_syrup_2 -> "2번"
        R.id.rb_syrup_3 -> "3번"
        else -> ""
    }

    private fun getSelectedCream() = when (binding.rgCream.checkedRadioButtonId) {
        R.id.rb_cream_none -> "없음"
        R.id.rb_cream_1 -> "1번"
        R.id.rb_cream_2 -> "2번"
        R.id.rb_cream_3 -> "3번"
        else -> ""
    }
}
