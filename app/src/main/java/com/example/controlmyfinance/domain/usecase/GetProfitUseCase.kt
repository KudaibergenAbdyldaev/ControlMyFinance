package com.example.controlmyfinance.domain.usecase

import com.example.controlmyfinance.domain.repository.ProfitRepository

class GetProfitUseCase(private val repository: ProfitRepository) {

    suspend fun getProfit() = repository.getProfit()

}