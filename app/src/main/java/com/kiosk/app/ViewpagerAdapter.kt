import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kiosk.app.espresso.EspressoFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragmentList = listOf(
        EspressoFragment(),
        // 다른 프래그먼트 추가
    )

    private val fragmentTitleList = listOf(
        "Espresso",
        "ColdBrew",
        "Blended",
        "Teabana",
        "Dessert",

    )

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList[position]
    }
}
