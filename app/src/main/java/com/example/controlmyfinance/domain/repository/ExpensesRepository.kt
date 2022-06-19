package com.example.controlmyfinance.domain.repository

import com.example.controlmyfinance.domain.model.Expenses
import kotlinx.coroutines.flow.Flow

interface ExpensesRepository {

    suspend fun getExpenses(): Flow<List<Expenses>>
    suspend fun setExpenses(expenses: Expenses)

}