package com.example.controlmyfinance.data.mapper

import com.example.controlmyfinance.data.extentions.saveFormattedDate
import com.example.controlmyfinance.data.local_db.model.ExpensesEntity
import com.example.controlmyfinance.domain.model.Expenses
import java.util.*

class ExpensesMapper {

    fun mapExpensesEntityListToExpensesList(entity: List<ExpensesEntity>): List<Expenses> {
        val list = mutableListOf<Expenses>()
        for (i in entity) {
            list.add(
                Expenses(
                    comment = i.comment,
                    sum = i.sum,
                    date = i.date.toString().saveFormattedDate(),
                    id = i.id ?: -1,
                    amount = i.amount,
                    isExpenses = true
                )
            )
        }
        return list
    }

    fun mapExpensesToExpensesEntity(expenses: Expenses): ExpensesEntity {

        return ExpensesEntity(
            id = null,
            comment = expenses.comment,
            sum = expenses.sum,
            date = Date(),
            amount = expenses.amount,
            isExpenses = expenses.isExpenses
        )
    }
}

//fun main() {
//    val dates = arrayOf("05-11-2014", "23-08-2014", "14-02-2013")
//    val dates2 = arrayOf("13-11-2014", "23-08-2014", "05-02-2013")
//    Arrays.sort(dates, object : Comparator<String?> {
//        private val sdf: SimpleDateFormat = SimpleDateFormat("dd")
//        override fun compare(o1: String?, o2: String?): Int {
//            var result = -1
//            try {
//                result = sdf.parse(o1).compareTo(sdf.parse(o2))
//            } catch (ex: ParseException) {
//                ex.printStackTrace()
//            }
//            return result
//        }
//    })
//
//    for (date in dates) {
//        for (i in dates2) {
//            if (i == date) {
//                println(date)
//            }
//        }
//
//    }
//}