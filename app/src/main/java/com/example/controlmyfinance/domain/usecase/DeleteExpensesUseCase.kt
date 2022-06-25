package com.example.controlmyfinance.domain.usecase

import com.example.controlmyfinance.domain.repository.ExpensesRepository

class DeleteExpensesUseCase(private val repository: ExpensesRepository) {

    suspend fun deleteExpenses(id: Int) {
        repository.deleteItem(id)
    }

}