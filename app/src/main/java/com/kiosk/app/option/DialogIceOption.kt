package com.kiosk.app.option

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.DialogIceOptionBinding
import com.kiosk.app.util.binding.BindingDialogFragment
import com.sopt.instagram.util.extension.setOnSingleClickListener

class DialogIceOption :
    BindingDialogFragment<DialogIceOptionBinding>(R.layout.dialog_ice_option) {

    private val viewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedItem.observe(viewLifecycleOwner) { selectedItem ->
            binding.ivMenuImage.setImageResource(selectedItem.image)
        }

        binding.btnOptionQuit.setOnSingleClickListener { dismiss() }
        fun View.setOptionClickListener(sizeText: String? = null) {
            setOnSingleClickListener {
                setBackgroundResource(R.color.yello_main_300)
                sizeText?.let { viewModel.updateSizeText(it) }
            }
        }

        with(binding) {
            layoutTallSize.setOptionClickListener("Tall Size")
            layoutGrandeSize.setOptionClickListener("Grande Size")
            layoutVentiSize.setOptionClickListener("Venti Size")
            layoutEspresso.setOptionClickListener()
            layoutSyrub.setOptionClickListener()
            layoutCream.setOptionClickListener()
        }
    }
}
