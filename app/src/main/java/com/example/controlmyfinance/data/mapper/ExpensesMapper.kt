package com.example.controlmyfinance.data.mapper

import com.example.controlmyfinance.data.extentions.saveFormattedDate
import com.example.controlmyfinance.data.local_db.model.ExpensesEntity
import com.example.controlmyfinance.domain.model.Expenses
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class ExpensesMapper {

    fun mapExpensesEntityListToExpensesList(entity: List<ExpensesEntity>): List<Expenses> {
        val list = mutableListOf<Expenses>()
        for (i in entity) {
            list.add(Expenses(i.comment, i.sum, i.date))
        }
        return list
    }

    fun mapExpensesToExpensesEntity(expenses: Expenses): ExpensesEntity {

        return ExpensesEntity(null, expenses.comment, expenses.sum, expenses.date.saveFormattedDate())
    }

}