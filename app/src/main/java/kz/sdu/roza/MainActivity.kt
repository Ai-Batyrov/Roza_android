package kz.sdu.roza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kz.sdu.roza.databinding.ActivityMainBinding
import kz.sdu.roza.presentation.menu.favorites.FavoritesMainFragment
import kz.sdu.roza.presentation.menu.home.HomeMainFragment
import kz.sdu.roza.presentation.menu.search.SearchMainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFragment(HomeMainFragment())

        binding.mainActivityBottomNavigationBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_nav_home_item -> setFragment(HomeMainFragment())
                R.id.bottom_nav_search_item -> setFragment(SearchMainFragment())
                R.id.bottom_nav_favorites_item -> setFragment(FavoritesMainFragment())

                else -> {}
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_activity_nav_host, fragment)
        fragmentTransaction.commit()
    }
}
