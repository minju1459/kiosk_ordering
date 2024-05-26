package com.kiosk.app.option

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.kiosk.app.MainViewModel
import com.kiosk.app.R
import com.kiosk.app.databinding.DialogReheatOptionBinding
import com.kiosk.app.util.binding.BindingDialogFragment

class DialogHeatOption :
    BindingDialogFragment<DialogReheatOptionBinding>(R.layout.dialog_reheat_option) {

    private val viewModel by activityViewModels<MainViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedItem.observe(viewLifecycleOwner) { selectedItem ->
            binding.ivSelectMenu.setImageResource(selectedItem.image)
            binding.tvMenuName.text = selectedItem.name
        }
    }
}
