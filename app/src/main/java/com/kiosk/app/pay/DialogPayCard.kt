package com.kiosk.app.pay

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.kiosk.app.HomeActivity
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.DialogPayCardBinding
import com.kiosk.app.util.binding.BindingDialogFragment
import com.sopt.instagram.util.extension.setOnSingleClickListener


class DialogPayCard(private var totalPrice: Int) : BindingDialogFragment<DialogPayCardBinding>(R.layout.dialog_pay_card) {

    private val viewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            tvAmount.text = totalPrice.toString()
            btnCancel.setOnSingleClickListener { dismiss() }
            btnApprove.setOnSingleClickListener { handlePayment() }
            tvUserPrice.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    updateRemainPrice()
                }
                override fun afterTextChanged(s: Editable?) {}
            })
        }
    }

    private fun updateRemainPrice() {
        val userPriceText = binding.tvUserPrice.text.toString()
        val userPrice = userPriceText.toIntOrNull()

        binding.tvRemainPrice.text = when {
            userPriceText.isEmpty() -> ""
            userPrice != null && userPrice <= totalPrice -> (totalPrice - userPrice).toString()
            else -> ""
        }
    }

    private fun handlePayment() {
        val userPriceText = binding.tvUserPrice.text.toString()
        if (userPriceText.isEmpty()) {
            Toast.makeText(context, "결제할 금액을 입력하세요.", Toast.LENGTH_SHORT).show()
            return
        }

        val userPrice = userPriceText.toIntOrNull()
        if (userPrice == null || userPrice <= 0) {
            Toast.makeText(context, "유효한 금액을 입력하세요.", Toast.LENGTH_SHORT).show()
            return
        }

        if (userPrice <= totalPrice) {
            totalPrice -= userPrice
            binding.tvRemainPrice.text = ""
            binding.tvUserPrice.text.clear()
            binding.tvAmount.text = totalPrice.toString()

            if (totalPrice == 0) {
                Toast.makeText(context, "결제가 완료되었습니다.", Toast.LENGTH_LONG).show()
                Handler(Looper.getMainLooper()).postDelayed({
                    navigateToHomeActivity()
                }, 1500)
            }
        } else {
            Toast.makeText(context, "총 금액보다 적은 금액을 입력하세요.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToHomeActivity() {
        val intent = Intent(activity, HomeActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }
}
