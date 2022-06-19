package com.example.controlmyfinance.data.local_db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profit")
data class ProfitEntity(
    @PrimaryKey val id: Int? = null,
    val comment: String,
    val sum: Double,
    val date: String
)