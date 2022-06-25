package com.example.controlmyfinance.presentation.expenses

import androidx.lifecycle.ViewModel
import com.example.controlmyfinance.domain.usecase.GetExpensesUseCase

class ExpensesViewModel(
    private val getExpensesUseCase: GetExpensesUseCase
) : ViewModel() {

    suspend fun getExpenses() = getExpensesUseCase.getExpenses()

}