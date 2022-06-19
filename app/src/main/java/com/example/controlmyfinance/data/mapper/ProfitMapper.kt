package com.example.controlmyfinance.data.mapper

import com.example.controlmyfinance.data.local_db.model.ProfitEntity
import com.example.controlmyfinance.domain.model.Profit

class ProfitMapper {

    fun mapProfitEntityListToProfitList(entity: List<ProfitEntity>): List<Profit> {
        val list = mutableListOf<Profit>()
        for (i in entity){
            list.add(Profit(i.comment, i.sum))
        }
        return list
    }

    fun mapProfitToProfitEntity(entity: Profit): ProfitEntity {
        return ProfitEntity(null, entity.comment, entity.sum)
    }

}