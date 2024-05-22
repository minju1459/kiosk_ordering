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
        binding.btnOptionQuit.setOnSingleClickListener {
            dismiss()
        }

        binding.layoutTallSize.setOnSingleClickListener {
            viewModel.updateSizeText("Tall Size")
            binding.layoutTallSize.setBackgroundResource(R.color.yello_main_300)
        }

        binding.layoutGrandeSize.setOnSingleClickListener {
            viewModel.updateSizeText("Grande Size")
            binding.layoutGrandeSize.setBackgroundResource(R.color.yello_main_300)
        }

        binding.layoutVentiSize.setOnSingleClickListener {
            viewModel.updateSizeText("Venti Size")
            binding.layoutVentiSize.setBackgroundResource(R.color.yello_main_300)
        }

        binding.layoutEspresso.setOnSingleClickListener {
            binding.layoutEspresso.setBackgroundResource(R.color.yello_main_300)
        }

        binding.layoutSyrub.setOnSingleClickListener {
            binding.layoutSyrub.setBackgroundResource(R.color.yello_main_300)
        }
        binding.layoutCream.setOnSingleClickListener {
            binding.layoutCream.setBackgroundResource(R.color.yello_main_300)
        }
    }
}
