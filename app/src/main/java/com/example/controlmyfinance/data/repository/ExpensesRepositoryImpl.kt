package com.example.controlmyfinance.data.repository

import com.example.controlmyfinance.data.local_db.dao.ExpensesDao
import com.example.controlmyfinance.data.mapper.ExpensesMapper
import com.example.controlmyfinance.domain.model.Expenses
import com.example.controlmyfinance.domain.repository.ExpensesRepository
import kotlinx.coroutines.flow.*

class ExpensesRepositoryImpl(
    private val mapper: ExpensesMapper,
    private val dao: ExpensesDao
) : ExpensesRepository {

    override suspend fun getExpenses(): Flow<List<Expenses>> {
        return dao.getExpensesItems().map {
            mapper.mapExpensesEntityListToExpensesList(it)
        }
    }

    override suspend fun setExpenses(expenses: Expenses) {
        dao.insertExpenses(mapper.mapExpensesToExpensesEntity(expenses))
    }

    override suspend fun deleteItem(id: Int) {
        dao.deleteExpenses(id)
    }
}