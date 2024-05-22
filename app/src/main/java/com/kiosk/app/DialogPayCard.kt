package com.kiosk.app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.kiosk.app.databinding.DialogPayCardBinding
import com.kiosk.app.util.binding.BindingDialogFragment

class DialogPayCard : BindingDialogFragment<DialogPayCardBinding>(R.layout.dialog_pay_card) {

    private val viewModel by activityViewModels<MainViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
