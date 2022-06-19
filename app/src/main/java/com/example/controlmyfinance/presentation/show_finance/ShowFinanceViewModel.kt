package com.example.controlmyfinance.presentation.show_finance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.controlmyfinance.data.local_db.shared_pref.SharedPreference

class ShowFinanceViewModel() : ViewModel() {

    private val _modeLiveData = MutableLiveData<Int>()
    val modeLiveData: LiveData<Int> = _modeLiveData

    //if mode equals 0 is expenses
    //if mode equals 1 is profit
    fun setMode(position: Int) {
        _modeLiveData.value = position
    }

}