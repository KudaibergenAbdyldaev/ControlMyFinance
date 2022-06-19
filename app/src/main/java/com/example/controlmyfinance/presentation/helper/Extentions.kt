package com.example.controlmyfinance.presentation.helper

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.controlmyfinance.R
import com.example.controlmyfinance.presentation.main.MainActivity

fun MainActivity.replaceFragment(fragment: Fragment){
    supportFragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .commitNow()
}
fun MainActivity.navigateBack(fragment: Fragment){
    supportFragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .addToBackStack(null)
        .commit()
}

fun MainActivity.handleOnBackPressed(fragment: Fragment){
    val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            navigateBack(fragment)
        }
    }
    onBackPressedDispatcher.addCallback(this, callback)
}