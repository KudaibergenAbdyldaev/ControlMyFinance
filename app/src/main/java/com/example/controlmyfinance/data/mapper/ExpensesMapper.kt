package com.example.controlmyfinance.data.mapper

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
        val date = expenses.date
        val originalFormat: DateFormat = SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.US);
        val targetFormat: DateFormat =
            SimpleDateFormat("HH:mm dd-MMM-yyyy", Locale.US);
        val parsedDate:Date = originalFormat.parse(date);
        val formattedDate = targetFormat.format(parsedDate);
        return ExpensesEntity(null, expenses.comment, expenses.sum, formattedDate)
    }

}