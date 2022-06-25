package com.example.controlmyfinance.data.repository

import com.example.controlmyfinance.data.local_db.dao.ProfitDao
import com.example.controlmyfinance.data.mapper.ProfitMapper
import com.example.controlmyfinance.domain.model.Profit
import com.example.controlmyfinance.domain.repository.ProfitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProfitRepositoryImpl(
    private val mapper: ProfitMapper,
    private val dao: ProfitDao
) : ProfitRepository {
    override suspend fun getProfit(): Flow<List<Profit>> {
        return dao.getProfitItems().map {
            mapper.mapProfitEntityListToProfitList(it)
        }
    }

    override suspend fun setProfit(profit: Profit) {
        dao.insertProfit(mapper.mapProfitToProfitEntity(profit))
    }

    override suspend fun deleteItem(id: Int) {
        dao.deleteProfit(id)
    }
}