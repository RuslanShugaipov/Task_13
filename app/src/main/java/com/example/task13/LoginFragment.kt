package com.example.task13

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.example.task13.databinding.ActivityMainBinding
import com.example.task13.databinding.FragmentLoginBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.btnSignUp.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.navigateToRegistrationFragment)
        }

        binding.btnSignIn.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.navigateToHomeFragment)
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}