package com.kiosk.app

import SelectMenuAdapter
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kiosk.app.databinding.ActivityMainBinding
import com.kiosk.app.util.binding.BindingActivity

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

        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()

        val selectMenuAdapter = SelectMenuAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = selectMenuAdapter

        viewModel.selectedItem.observe(this) { selectedItem ->
            selectedItem?.let {
                selectMenuAdapter.addItems(listOf(it))
            }
        }
    }
}
