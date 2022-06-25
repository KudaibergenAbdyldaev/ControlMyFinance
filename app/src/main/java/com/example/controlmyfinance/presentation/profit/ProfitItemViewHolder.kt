package com.example.controlmyfinance.presentation.profit

import androidx.recyclerview.widget.RecyclerView
import com.example.controlmyfinance.databinding.FinanceItemBinding
import com.example.controlmyfinance.domain.model.Profit

class ProfitItemViewHolder(
    val binding: FinanceItemBinding
) : RecyclerView.ViewHolder(binding.root){
    fun bind(profit: Profit){
        binding.comment.text = profit.comment
        binding.sum.text = profit.sum.toString()
        binding.date.text = profit.date.toString()
    }
}
