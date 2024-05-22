package com.kiosk.app

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.kiosk.app.databinding.DialogPayCardBinding
import com.kiosk.app.util.binding.BindingDialogFragment
import com.sopt.instagram.util.extension.setOnSingleClickListener

class DialogPayCard(private val totalPrice: Int) : BindingDialogFragment<DialogPayCardBinding>(R.layout.dialog_pay_card) {

    private val viewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvAmount.text = totalPrice.toString()

        binding.btnApprove.setOnSingleClickListener {
            Toast.makeText(this.context, "결제 승인 요청 중입니다.", Toast.LENGTH_LONG).show()

            Handler(Looper.getMainLooper()).postDelayed({
                Toast.makeText(this.context, "결제가 완료되었습니다.", Toast.LENGTH_SHORT).show()
            }, 3000)
        }
    }
}