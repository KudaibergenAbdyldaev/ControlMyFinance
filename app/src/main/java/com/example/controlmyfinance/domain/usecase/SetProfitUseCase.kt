package com.example.controlmyfinance.domain.usecase

import com.example.controlmyfinance.domain.model.Profit
import com.example.controlmyfinance.domain.repository.ProfitRepository

class SetProfitUseCase(private val repository: ProfitRepository) {

    suspend fun setProfitUseCase(profit: Profit) {
        repository.setProfit(profit)
    }

}