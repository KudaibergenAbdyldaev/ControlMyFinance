package com.example.controlmyfinance.data.local_db.shared_pref

import android.content.Context
import android.content.SharedPreferences

class SharedPreference(val context: Context) {

    companion object {
        private const val sharedPreferences = "sharedPreferences"
    }

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(sharedPreferences, Context.MODE_PRIVATE)

}