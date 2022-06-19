package com.example.controlmyfinance.domain.repository

import com.example.controlmyfinance.domain.model.Profit
import kotlinx.coroutines.flow.Flow

interface ProfitRepository {

    suspend fun getProfit(): Flow<List<Profit>>
    suspend fun setProfit(profits: Profit)

}