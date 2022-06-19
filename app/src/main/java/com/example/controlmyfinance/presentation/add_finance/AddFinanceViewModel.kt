package com.example.controlmyfinance.presentation.add_finance

import androidx.lifecycle.ViewModel
import com.example.controlmyfinance.domain.usecase.SetExpensesUseCase
import com.example.controlmyfinance.domain.usecase.SetProfitUseCase

class AddFinanceViewModel(
    private val setProfitUseCase: SetProfitUseCase,
    private val setExpensesUseCase: SetExpensesUseCase
) : ViewModel() {



}