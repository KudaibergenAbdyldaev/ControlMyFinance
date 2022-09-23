package com.example.controlmyfinance.data.repository

import android.util.Log
import com.example.controlmyfinance.data.local_db.dao.ExpensesDao
import com.example.controlmyfinance.data.mapper.ExpensesMapper
import com.example.controlmyfinance.domain.model.Expenses
import com.example.controlmyfinance.domain.repository.ExpensesRepository
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ExpensesRepositoryImpl(
    private val mapper: ExpensesMapper,
    private val dao: ExpensesDao,
    private val database: DatabaseReference
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

    override suspend fun setExpensesFromFirebase() {
        database.child(myFinance).get().addOnSuccessListener {
            it.children.forEach { list ->
                CoroutineScope(Dispatchers.IO).launch {
                    dao.insertExpenses(
                        mapper.mapExpensesToExpensesEntity(
                            Expenses(
                                comment = list.child(comment).value.toString(),
                                sum = list.child(sum).value.toString().toDouble(),
                                date = list.child(date).value.toString(),
                                isExpenses = list.child(expenses).value.toString().toBoolean(),
                                id = list.child(id).value.toString().toInt(),
                                amount = list.child(amount).value.toString().toInt()
                            )
                        )
                    )
                }
            }
        }.addOnFailureListener {
            Log.e("firebase", "Error getting data", it)
        }
    }

    override suspend fun saveExpensesToFirebase(list: List<Expenses>) {
        for (i in list){
            database.child(myFinance).child(i.id.toString()).setValue(i)
        }
    }

    companion object {
        private const val myFinance = "myFinance"
        private const val comment = "comment"
        private const val sum = "sum"
        private const val date = "date"
        private const val expenses = "expenses"
        private const val id = "id"
        private const val amount = "amount"
    }

}