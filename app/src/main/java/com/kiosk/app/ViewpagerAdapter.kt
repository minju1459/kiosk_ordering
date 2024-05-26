package com.kiosk.app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kiosk.app.blended.BlendedFragment
import com.kiosk.app.coldbrew.ColdBrewFragment
import com.kiosk.app.dessert.FrappuccinoFragment
import com.kiosk.app.espresso.EspressoFragment
import com.kiosk.app.teabana.TeabanaFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragmentList = listOf(
        EspressoFragment(),
        ColdBrewFragment(),
        BlendedFragment(),
        TeabanaFragment(),
        FrappuccinoFragment(),
    )

    private val fragmentTitleList = listOf(
        "Espresso",
        "ColdBrew",
        "Blended",
        "Teabana",
        "Frappuccino",
    )

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList[position]
    }
}
