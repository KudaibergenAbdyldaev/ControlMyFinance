package com.example.controlmyfinance.data.local_db.dao

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao
import androidx.room.Delete
import com.example.controlmyfinance.data.local_db.model.ProfitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfitDao {
    @Insert
    fun insertProfit(program: ProfitEntity)

    @Query("SELECT * FROM profit")
    fun getProfitItems(): Flow<List<ProfitEntity>>

    @Query("DELETE FROM profit WHERE id=:id")
    fun deleteProfit(id: Int)
}