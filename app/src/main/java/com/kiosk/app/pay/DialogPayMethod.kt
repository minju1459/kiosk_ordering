package com.kiosk.app.pay

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.DialogPayMethodBinding
import com.kiosk.app.util.binding.BindingDialogFragment
import com.sopt.instagram.util.extension.setOnSingleClickListener

class DialogPayMethod(private val totalPrice: Int) :
    BindingDialogFragment<DialogPayMethodBinding>(R.layout.dialog_pay_method) {

    private val viewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCard.setOnSingleClickListener {
            val dialog = DialogPayCard(totalPrice)
            dialog.show(requireActivity().supportFragmentManager, "DialogPayCard")
            binding.btnCard.setBackgroundResource(R.color.yello_main_300)
        }
    }
}
