package com.kiosk.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kiosk.app.databinding.ActivityMainBinding
import com.kiosk.app.util.binding.BindingActivity
import com.sopt.instagram.util.extension.setOnSingleClickListener

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel by viewModels<MainViewModel>()

    private var _adapter: SelectMenuAdapter? = null
    private val adapter
        get() = requireNotNull(_adapter) { getString(R.string.adapter_not_initialized_error_msg) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewPager: ViewPager2 = binding.vpMenu
        val tabLayout: TabLayout = binding.toolbarMenu
        val recyclerView = binding.rvSelectMenu

        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = viewPagerAdapter.getPageTitle(position)
        }.attach()

        _adapter = SelectMenuAdapter(viewModel)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.selectedItem.observe(this) { selectedItem ->
            selectedItem?.let {
                adapter.addItems(listOf(it))
            }
        }

        viewModel.totalItemCount.observe(
            this,
            Observer { totalCount ->
                binding.tvTotalCount.text = totalCount.toString()
            },
        )

        viewModel.totalItemPrice.observe(
            this,
            Observer { totalPrice ->
                binding.tvTotalPrice.text = totalPrice.toString()
            },
        )
        binding.btnPayCard.setOnSingleClickListener {
            val dialog = DialogPayCard()
            dialog.show(supportFragmentManager, "DialogPayCard")
        }
    }
}
