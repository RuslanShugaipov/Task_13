package com.example.task13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.task13.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNav()
    }

    private fun showBottomNav() = with(binding) {
        bottomNav.visibility = View.VISIBLE
    }

    private fun hideBottomNav() = with(binding) {
        bottomNav.visibility = View.GONE
    }

    private var activeFragment: Fragment = HomeFragment()

    private fun setupNav() {
        val navBar = findViewById<BottomNavigationView>(R.id.bottomNav)
        val navController = (supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
                as NavHostFragment).navController
        navBar.setupWithNavController(navController)

        navBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.goHome -> {
                    if (navController.currentDestination?.id != navController.graph.findNode(R.id.homeFragment)?.id)
                        navController.navigate(R.id.navigateToHomeFragment)
                }
                R.id.goWeb -> {
                    if (navController.currentDestination?.id != navController.graph.findNode(R.id.webFragment)?.id)
                        navController.navigate(R.id.navigateToWebFragment)
                }
            }
            true
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment -> hideBottomNav()
                R.id.registrationFragment -> hideBottomNav()
                R.id.homeFragment -> showBottomNav()
                R.id.webFragment -> showBottomNav()
            }
        }
    }

    override fun onBackPressed() {
        val wb = findViewById<WebView>(R.id.webView)
        if (wb.canGoBack()) {
            wb.goBack()
        } else {
            super.onBackPressed()
        }
    }
}