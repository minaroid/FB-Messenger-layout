package messenger.mina.com.messenger.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import messenger.mina.com.messenger.ui.fragments.ChatsFragment

class HomePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ChatsFragment.newInstance()
            1 -> ChatsFragment.newInstance()
            2 -> ChatsFragment.newInstance()
            else -> ChatsFragment.newInstance()
        }
    }

    override fun getCount(): Int = 3
}