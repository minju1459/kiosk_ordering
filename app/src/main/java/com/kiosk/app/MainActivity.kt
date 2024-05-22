package com.kiosk.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.kiosk.app.databinding.ActivityMainBinding
import com.kiosk.app.util.binding.BindingActivity
import com.sopt.instagram.util.extension.setOnSingleClickListener

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel by viewModels<MainViewModel>()

    private val adapter by lazy { SelectMenuAdapter(viewModel) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewPagerAndTabLayout()
        with(binding.rvSelectMenu) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@MainActivity.adapter
        }
        observeViewModel()
        binding.btnPayCard.setOnSingleClickListener { showPaymentDialog() }
        binding.btnBackHome.setOnSingleClickListener { navigateToHome() }
    }

    private fun setupViewPagerAndTabLayout() {
        with(binding) {
            val viewPagerAdapter = ViewPagerAdapter(this@MainActivity)
            vpMenu.adapter = viewPagerAdapter
            TabLayoutMediator(toolbarMenu, vpMenu) { tab, position ->
                tab.text = viewPagerAdapter.getPageTitle(position)
            }.attach()
        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            selectedItem.observe(this@MainActivity) { selectedItem ->
                selectedItem?.let {
                    adapter.addItems(listOf(it))
                }
            }
            totalItemCount.observe(this@MainActivity) { totalCount ->
                binding.tvTotalCount.text = totalCount.toString()
            }
            totalItemPrice.observe(this@MainActivity) { totalPrice ->
                binding.tvTotalPrice.text = totalPrice.toString()
            }
        }
    }

    private fun showPaymentDialog() {
        val totalPrice = viewModel.totalItemPrice.value ?: 0
        val dialog = DialogPayMethod(totalPrice)
        dialog.show(supportFragmentManager, "DialogPayMethod")
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
