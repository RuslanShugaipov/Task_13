package com.example.task13

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.task13.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRegistrationBinding.inflate(inflater, container, false)

        binding.btnSignUp.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.navigateToLoginFragment)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragment()
    }
}