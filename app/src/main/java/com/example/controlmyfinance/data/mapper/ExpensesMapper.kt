package com.example.controlmyfinance.data.mapper

import com.example.controlmyfinance.data.local_db.model.ExpensesEntity
import com.example.controlmyfinance.domain.model.Expenses

class ExpensesMapper {

    fun mapExpensesEntityListToExpensesList(entity: List<ExpensesEntity>): List<Expenses> {
        val list = mutableListOf<Expenses>()
        for (i in entity){
            list.add(Expenses(i.comment, i.sum))
        }
        return list
    }

    fun mapExpensesToExpensesEntity(entity: Expenses): ExpensesEntity {
        return ExpensesEntity(null, entity.comment, entity.sum)
    }

}