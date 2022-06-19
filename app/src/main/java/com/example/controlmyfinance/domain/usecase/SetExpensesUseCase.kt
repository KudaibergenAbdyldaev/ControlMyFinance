package com.example.controlmyfinance.domain.usecase

import com.example.controlmyfinance.domain.model.Expenses
import com.example.controlmyfinance.domain.repository.ExpensesRepository

class SetExpensesUseCase(private val repository: ExpensesRepository) {

    suspend fun setExpenses(expenses: Expenses) {
        repository.setExpenses(expenses)
    }

}