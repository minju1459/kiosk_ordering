package com.kiosk.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.kiosk.app.databinding.DialogPayCardBinding
import com.kiosk.app.util.binding.BindingDialogFragment
import com.sopt.instagram.util.extension.setOnSingleClickListener
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DialogPayCard(private val totalPrice: Int) : BindingDialogFragment<DialogPayCardBinding>(R.layout.dialog_pay_card) {

    private val viewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tvAmount.text = totalPrice.toString()

            btnCancel.setOnSingleClickListener { dismiss() }

            btnApprove.setOnSingleClickListener {
                showToast("결제 승인 요청 중입니다.")
                lifecycleScope.launch {
                    delay(2000)
                    showToast("결제가 완료되었습니다.")
                    delay(3000)
                    navigateToHome()
                }
            }
        }
    }

    private fun navigateToHome() {
        val intent = Intent(requireContext(), HomeActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
