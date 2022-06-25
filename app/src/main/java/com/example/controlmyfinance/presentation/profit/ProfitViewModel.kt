package com.example.controlmyfinance.presentation.profit

import androidx.lifecycle.ViewModel
import com.example.controlmyfinance.domain.usecase.GetProfitUseCase

class ProfitViewModel(
    private val getProfitUseCase: GetProfitUseCase
) : ViewModel() {

    suspend fun getProfit() = getProfitUseCase.getProfit()

}