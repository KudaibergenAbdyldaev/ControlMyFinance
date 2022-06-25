package com.example.controlmyfinance.presentation.profit

import androidx.recyclerview.widget.DiffUtil
import com.example.controlmyfinance.domain.model.Profit

class ItemDiffCallback: DiffUtil.ItemCallback<Profit>() {

    override fun areItemsTheSame(oldItem: Profit, newItem: Profit): Boolean {
        return oldItem.comment == newItem.comment
    }

    override fun areContentsTheSame(oldItem: Profit, newItem: Profit): Boolean {
        return oldItem == newItem
    }
}
