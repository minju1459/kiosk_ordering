package com.kiosk.app.option

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.DialogDrinkOptionBinding
import com.kiosk.app.util.binding.BindingDialogFragment
import com.sopt.instagram.util.extension.setOnSingleClickListener

class DialogDrinkOption :
    BindingDialogFragment<DialogDrinkOptionBinding>(R.layout.dialog_drink_option) {

    private val viewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image = arguments?.getInt("image", 0)
        val name = arguments?.getString("name", "")

        if (image != null) {
            binding.ivMenuImage.setImageResource(image)
        }
        binding.tvMenuName.text = name
        binding.btnOptionQuit.setOnSingleClickListener { dismiss() }
    }
}
