package com.example.controlmyfinance.domain.usecase

import com.example.controlmyfinance.domain.repository.ExpensesRepository

class GetExpensesUseCase(private val repository: ExpensesRepository) {

    suspend fun getExpenses() = repository.getExpenses()

}