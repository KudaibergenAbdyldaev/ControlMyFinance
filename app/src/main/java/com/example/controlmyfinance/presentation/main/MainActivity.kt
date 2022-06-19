package com.example.controlmyfinance.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.controlmyfinance.R
import com.example.controlmyfinance.presentation.helper.replaceFragment
import com.example.controlmyfinance.presentation.show_finance.ShowFinanceFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(ShowFinanceFragment())
    }

}