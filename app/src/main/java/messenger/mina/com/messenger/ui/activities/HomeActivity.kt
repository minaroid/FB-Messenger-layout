package messenger.mina.com.messenger.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

import messenger.mina.com.messenger.R
import messenger.mina.com.messenger.adapters.HomePagerAdapter

class HomeActivity : AppCompatActivity() {

    private lateinit var homePagerAdapter: HomePagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        intiViewPager()

    }

    private fun intiViewPager() {
        homePagerAdapter = HomePagerAdapter(supportFragmentManager)
        viewPager.adapter = homePagerAdapter
        pagerTabs.setupWithViewPager(viewPager)
        for (pos in 0 until pagerTabs.tabCount) {
            val tab = pagerTabs.getTabAt(pos)
            tab!!.customView = getTabView(pos)
        }

    }

    private fun getTabView(pos: Int): View? {
        return when (pos) {
            0 -> LayoutInflater.from(this).inflate(R.layout.tab_chats, null)
            1 -> LayoutInflater.from(this).inflate(R.layout.tab_friends, null)
            2 -> LayoutInflater.from(this).inflate(R.layout.tab_compass, null)
            else -> return null
        }
    }
}
