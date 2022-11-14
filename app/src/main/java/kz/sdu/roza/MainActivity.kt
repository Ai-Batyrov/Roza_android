package kz.sdu.roza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kz.sdu.roza.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBottomNavigation()
    }

    private fun setBottomNavigation() {
        val bottomNavigationView: BottomNavigationView = binding.mainActivityBottomNavigationBar
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_activity_nav_host) as NavHostFragment
        bottomNavigationView.setupWithNavController(navHostFragment.navController)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_nav_home_item -> {
                    navHostFragment.navController.navigate(R.id.homeMainFragment)
                    true
                }
                R.id.bottom_nav_search_item -> {
                    navHostFragment.navController.navigate(R.id.searchMainFragment)
                    true
                }
                R.id.bottom_nav_favorites_item -> {
                    navHostFragment.navController.navigate(R.id.favoritesMainFragment)
                    true
                }
                R.id.bottom_nav_burger_menu_item -> {
                    navHostFragment.navController.navigate(R.id.burgerMenuFragment)
                    true
                }
                else -> false
            }
        }
    }
}
