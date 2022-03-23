package com.example.task13

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.get
import androidx.core.view.iterator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task13.databinding.FragmentHomeBinding
import kotlinx.coroutines.delay
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val adapter = RVAdapter()
    private val stringList = listOf(
        "asus", "acer", "msi", "hp",
        "dell", "lenovo", "huawei", "alianware"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initRV()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnClk.setOnClickListener {
            object : CountDownTimer(5000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    changeStyle()
                }
                override fun onFinish() {
                }
            }.start()
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    private fun initRV() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(this@HomeFragment.context)
        rcView.adapter = adapter
        for (element in stringList) {
            adapter.addString(element)
        }
    }

    fun changeStyle() {
        adapter.clear()
        adapter.changeStyle()
        initRV()
    }
}