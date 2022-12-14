package com.example.task13

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import com.example.task13.databinding.ActivityMainBinding
import com.example.task13.databinding.FragmentWebBinding

class WebFragment : Fragment() {
    private lateinit var binding: FragmentWebBinding
    private var webViewState: Bundle? = null

    override fun onPause() {
        super.onPause()

        webViewState = Bundle()
        binding.webView.saveState(webViewState!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentWebBinding.inflate(inflater, container, false)

        webViewSetup()

        if (webViewState != null) {
            binding.webView.restoreState(webViewState!!)
        } else {
            binding.webView.loadUrl("https://www.google.com/")
        }

        return binding.root
    }

    private fun webViewSetup() {
        binding.webView.webViewClient = WebViewClient()
    }

    companion object {
        @JvmStatic
        fun newInstance() = WebFragment()
    }
}