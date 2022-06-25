package com.example.controlmyfinance.data.local_db.dao

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao
import androidx.room.Delete
import com.example.controlmyfinance.data.local_db.model.ExpensesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpensesDao {
    @Insert
    fun insertExpenses(program: ExpensesEntity)

    @Query("SELECT * FROM expenses")
    fun getExpensesItems(): Flow<List<ExpensesEntity>>

    @Query("DELETE FROM expenses WHERE id=:id")
    fun deleteExpenses(id: Int)
}