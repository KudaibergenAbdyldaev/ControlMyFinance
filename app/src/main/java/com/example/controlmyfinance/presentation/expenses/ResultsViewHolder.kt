package com.example.controlmyfinance.presentation.expenses

import androidx.recyclerview.widget.RecyclerView
import com.example.controlmyfinance.databinding.ResultsItemBinding

class ResultsViewHolder(
    val binding: ResultsItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(resultText: String, result: String) {
        binding.result.text = result
        binding.resultTxt.text = resultText
    }
}