package com.example.controlmyfinance.data.local_db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.controlmyfinance.data.local_db.converter.TimestampConverter
import java.util.*

@TypeConverters(TimestampConverter::class)
@Entity(tableName = "expenses")
data class ExpensesEntity(
    @PrimaryKey val id: Int?=null,
    val comment: String,
    val sum: Double,
    val date: Date,
    val amount: Int,
    val isExpenses: Boolean
)
