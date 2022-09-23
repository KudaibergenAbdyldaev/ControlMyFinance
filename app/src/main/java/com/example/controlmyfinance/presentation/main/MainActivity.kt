package com.example.controlmyfinance.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.controlmyfinance.R
import com.example.controlmyfinance.databinding.ActivityMainBinding
import com.example.controlmyfinance.presentation.add_finance.AddFinanceFragment
import com.example.controlmyfinance.presentation.expenses.ExpensesFragment
import com.example.controlmyfinance.presentation.helper.replaceFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(ExpensesFragment())

        binding.fab.setOnClickListener {
            replaceFragment(AddFinanceFragment())
        }
    }


}