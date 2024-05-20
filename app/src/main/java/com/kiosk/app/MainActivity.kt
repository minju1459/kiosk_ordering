package com.kiosk.app

import SelectMenuAdapter
import ViewPagerAdapter
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kiosk.app.databinding.ActivityMainBinding
import com.sopt.instagram.util.binding.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
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

        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = listOf(
            Item(R.drawable.img_green, "바닐라 칩 에스프레소", "5000원"),
            Item(R.drawable.img_green, "Cold Brew", "6000원"),
            Item(R.drawable.img_green, "Blended", "7000원"),
            Item(R.drawable.img_green, "Teabana", "8000원"),
            Item(R.drawable.img_green, "Dessert", "9000원"),
        )
        val selectMenuAdapter = SelectMenuAdapter(items)
        recyclerView.adapter = selectMenuAdapter
    }
}
