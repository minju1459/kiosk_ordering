package com.kiosk.app.dessert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.kiosk.app.R
import com.kiosk.app.databinding.FragmentDessertBinding

class DessertFragment : Fragment() {

    private var _binding: FragmentDessertBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDessertBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.rvDessert
        recyclerView.layoutManager = GridLayoutManager(context, 4)
        recyclerView.adapter = DessertAdapter(getItems())
    }

    private fun getItems(): List<Item> {
        return listOf(
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
            Item(R.drawable.ic_main_delete, "딸기 라떼", "3500원"),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
