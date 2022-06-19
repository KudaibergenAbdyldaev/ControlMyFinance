package com.example.controlmyfinance.presentation.expenses

import androidx.recyclerview.widget.DiffUtil
import com.example.controlmyfinance.domain.model.Expenses

class ItemDiffCallback: DiffUtil.ItemCallback<Expenses>() {

    override fun areItemsTheSame(oldItem: Expenses, newItem: Expenses): Boolean {
        return oldItem.comment == newItem.comment
    }

    override fun areContentsTheSame(oldItem: Expenses, newItem: Expenses): Boolean {
        return oldItem == newItem
    }
}
