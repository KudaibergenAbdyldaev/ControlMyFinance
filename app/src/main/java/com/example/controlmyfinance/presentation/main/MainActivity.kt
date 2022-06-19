package com.example.controlmyfinance.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.example.controlmyfinance.databinding.ActivityMainBinding
import com.example.controlmyfinance.presentation.add_finance.AddFinanceFragment
import com.example.controlmyfinance.presentation.helper.replaceFragment
import com.example.controlmyfinance.presentation.show_finance.ShowFinanceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(ShowFinanceFragment())

        binding.fab.setOnClickListener {
            replaceFragment(AddFinanceFragment())
            binding.fab.visibility = View.GONE
        }
    }

}