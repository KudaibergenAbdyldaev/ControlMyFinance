package com.example.controlmyfinance.presentation.profit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.controlmyfinance.domain.model.Profit
import com.example.controlmyfinance.domain.usecase.DeleteProfitUseCase
import com.example.controlmyfinance.domain.usecase.GetProfitUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfitViewModel(
    private val getProfitUseCase: GetProfitUseCase,
    private val deleteProfitUseCase: DeleteProfitUseCase
) : ViewModel() {

    suspend fun getProfit() = getProfitUseCase.getProfit()

    fun delete(profit: Profit) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteProfitUseCase.deleteProfit(profit.id ?: -1)
        }
    }
}