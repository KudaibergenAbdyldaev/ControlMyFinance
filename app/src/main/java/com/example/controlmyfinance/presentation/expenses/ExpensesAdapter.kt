package com.example.controlmyfinance.presentation.expenses

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.controlmyfinance.R
import com.example.controlmyfinance.databinding.FinanceItemBinding
import com.example.controlmyfinance.databinding.ResultsItemBinding
import com.example.controlmyfinance.domain.model.Expenses

class ExpensesAdapter : ListAdapter<Expenses, RecyclerView.ViewHolder>(ItemDiffCallback()) {

    var onShopItemLongClickListener: ((Expenses) -> Unit)? = null
    var onItemClickListener: ((Expenses) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_DAY -> {
                val layout =
                    ResultsItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                ResultsViewHolder(layout)
            }
            VIEW_TYPE_FINANCE -> {
                val layout =
                    FinanceItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                ExpensesItemViewHolder(layout)
            }
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        return layout
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        viewHolder as ExpensesItemViewHolder
        val shopItem = getItem(position)
        val binding = viewHolder.binding
        viewHolder.bind(shopItem)

//        binding.root.setOnLongClickListener {
//            onShopItemLongClickListener?.invoke(shopItem)
//            true
//        }
        binding.root.setOnClickListener {
            onItemClickListener?.invoke(shopItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return VIEW_TYPE_FINANCE
//        return if (item.enabled) {
//            VIEW_TYPE_FINANCE
//        } else {
//            VIEW_TYPE_DAY
//        }
    }

    companion object {

        const val VIEW_TYPE_FINANCE = 100
        const val VIEW_TYPE_DAY = 101
        const val VIEW_TYPE_WEEK = 101
        const val VIEW_TYPE_MONTH = 101

        const val MAX_POOL_SIZE = 30
    }

}