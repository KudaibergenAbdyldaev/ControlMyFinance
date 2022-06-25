package com.example.controlmyfinance.data.mapper

import com.example.controlmyfinance.data.extentions.saveFormattedDate
import com.example.controlmyfinance.data.local_db.model.ProfitEntity
import com.example.controlmyfinance.domain.model.Profit
import java.util.*

class ProfitMapper {

    fun mapProfitEntityListToProfitList(entity: List<ProfitEntity>): List<Profit> {
        val list = mutableListOf<Profit>()
        for (i in entity) {
            list.add(
                Profit(
                    comment = i.comment,
                    sum = i.sum,
                    date = i.date.toString().saveFormattedDate(),
                    id = i.id ?: -1
                )
            )
        }
        return list
    }

    fun mapProfitToProfitEntity(model: Profit): ProfitEntity {
        return ProfitEntity(
            id = null,
            comment = model.comment,
            sum = model.sum,
            date = Date()
        )
    }

}