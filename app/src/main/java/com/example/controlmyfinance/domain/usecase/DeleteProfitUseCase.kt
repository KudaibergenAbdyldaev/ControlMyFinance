package com.example.controlmyfinance.domain.usecase

import com.example.controlmyfinance.domain.repository.ProfitRepository

class DeleteProfitUseCase(private val repository: ProfitRepository) {

    suspend fun deleteProfit(id: Int) {
        repository.deleteItem(id)
    }

}