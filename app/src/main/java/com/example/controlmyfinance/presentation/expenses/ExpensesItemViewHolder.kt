package com.example.controlmyfinance.presentation.expenses

import androidx.recyclerview.widget.RecyclerView
import com.example.controlmyfinance.databinding.FinanceItemBinding
import com.example.controlmyfinance.domain.model.Expenses

class ExpensesItemViewHolder(
    val binding: FinanceItemBinding
) : RecyclerView.ViewHolder(binding.root){
    fun bind(expenses: Expenses){
        binding.comment.text = expenses.comment
        binding.sum.text = expenses.sum.toString()
        binding.date.text = expenses.date.toString()
    }
}
