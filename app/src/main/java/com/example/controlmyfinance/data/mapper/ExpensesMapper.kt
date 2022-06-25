package com.example.controlmyfinance.data.mapper

import com.example.controlmyfinance.data.extentions.saveFormattedDate
import com.example.controlmyfinance.data.local_db.model.ExpensesEntity
import com.example.controlmyfinance.domain.model.Expenses

class ExpensesMapper {

    fun mapExpensesEntityListToExpensesList(entity: List<ExpensesEntity>): List<Expenses> {
        val list = mutableListOf<Expenses>()
        for (i in entity) {
            list.add(Expenses(comment = i.comment, sum = i.sum, date = i.date, id = i.id ?: -1))
        }
        return list
    }

    fun mapExpensesToExpensesEntity(expenses: Expenses): ExpensesEntity {

        return ExpensesEntity(
            id = null,
            comment = expenses.comment,
            sum = expenses.sum,
            date = expenses.date.saveFormattedDate()
        )
    }

    fun mapExpensesToExpensesEntityForDelete(expenses: Expenses): ExpensesEntity {

        return ExpensesEntity(
            id = null, comment = expenses.comment, sum = expenses.sum, date = expenses.date
        )
    }

}