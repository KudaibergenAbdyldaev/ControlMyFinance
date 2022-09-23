package com.example.controlmyfinance.presentation.expenses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.controlmyfinance.domain.model.Expenses
import com.example.controlmyfinance.domain.usecase.DeleteExpensesUseCase
import com.example.controlmyfinance.domain.usecase.GetExpensesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExpensesViewModel(
    private val getExpensesUseCase: GetExpensesUseCase,
    private val deleteExpensesUseCase: DeleteExpensesUseCase
) : ViewModel() {

    suspend fun getExpenses() = getExpensesUseCase.getExpenses()

    init {
//        setExpensesFromFirebaseToCache()
    }

    private fun setExpensesFromFirebaseToCache() =
        viewModelScope.launch { getExpensesUseCase.getExpensesFromFirebaseAndSaveInCache() }

    fun delete(expenses: Expenses) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteExpensesUseCase.deleteExpenses(expenses.id ?: -1)
        }
    }

}