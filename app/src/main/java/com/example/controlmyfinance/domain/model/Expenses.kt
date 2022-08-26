package com.example.controlmyfinance.domain.model

data class Expenses(
    val comment: String,
    val sum: Double,
    val date: String,
    val id: Int?,
    val amount: Int,
    val isExpenses: Boolean
)
