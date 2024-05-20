package com.kiosk.app.espresso

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.Item
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentEspressoBinding

class EspressoFragment : Fragment() {

    private var _binding: FragmentEspressoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentEspressoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvEspresso.layoutManager = GridLayoutManager(context, 4)
        binding.rvEspresso.adapter = EspressoAdapter(getItems())
    }

    private fun getItems(): List<Item> {
        return listOf(
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
            Item(R.drawable.img_green, "딸기 라떼", "3500원"),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
