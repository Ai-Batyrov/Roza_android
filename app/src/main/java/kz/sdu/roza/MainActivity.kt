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

        val bottomNavigationView: BottomNavigationView = binding.mainActivityBottomNavigationBar
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_activity_nav_host) as NavHostFragment
        bottomNavigationView.setupWithNavController(navHostFragment.navController)
    }
}
