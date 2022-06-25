package com.example.controlmyfinance.presentation.add_finance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.controlmyfinance.domain.model.Expenses
import com.example.controlmyfinance.domain.model.Profit
import com.example.controlmyfinance.domain.usecase.SetExpensesUseCase
import com.example.controlmyfinance.domain.usecase.SetProfitUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class AddFinanceViewModel(
    private val setProfitUseCase: SetProfitUseCase,
    private val setExpensesUseCase: SetExpensesUseCase
) : ViewModel() {

    private val _modeLiveData = MutableLiveData<Int>()
    val modeLiveData: LiveData<Int> = _modeLiveData

    private val _isSuccessLiveData = MutableLiveData<Boolean>()
    val isSuccessLiveData: LiveData<Boolean> = _isSuccessLiveData

    //if mode equals 0 is expenses
    //if mode equals 1 is profit
    fun setMode(position: Int) {
        _modeLiveData.value = position
    }

    fun clearIsSuccess(){
        _isSuccessLiveData.value = false
    }

    fun setFinance(comment: String, sum: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            if (_modeLiveData.value == MODE_EXPENSES) {
                setExpensesUseCase.setExpenses(Expenses(
                    comment = comment,
                    sum = sum,
                    date = Date().toString(),
                    id = null
                ))
            } else {
                setProfitUseCase.setProfitUseCase(Profit(
                    comment = comment,
                    sum = sum,
                    date = Date().toString(),
                    id = null
                ))
            }
            _isSuccessLiveData.postValue(true)
        }
    }

    companion object {
        const val MODE_EXPENSES = 0
        const val MODE_PROFIT = 1
    }

}