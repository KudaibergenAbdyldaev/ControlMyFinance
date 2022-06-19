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
    suspend fun insertProfit(program: ProfitEntity)

    @Query("SELECT * FROM profit")
    suspend fun getProfitItems(): Flow<List<ProfitEntity>>

    @Delete
    fun deleteProfit(profitEntity: ProfitEntity)
}