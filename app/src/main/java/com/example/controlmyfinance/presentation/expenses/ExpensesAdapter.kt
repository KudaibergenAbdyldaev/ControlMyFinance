package com.example.controlmyfinance.presentation.expenses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.controlmyfinance.databinding.FinanceItemBinding
import com.example.controlmyfinance.domain.model.Expenses

class ExpensesAdapter : ListAdapter<Expenses, ExpensesItemViewHolder>(ItemDiffCallback()) {

    var onShopItemLongClickListener: ((Expenses) -> Unit)? = null
    var onShopItemClickListener: ((Expenses) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesItemViewHolder {
//        val layout = when (viewType) {
//            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
//            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
//            else -> throw RuntimeException("Unknown view type: $viewType")
//        }
        val binding = FinanceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpensesItemViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ExpensesItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        val binding = viewHolder.binding
        viewHolder.bind(shopItem)
//        binding.root.setOnLongClickListener {
//            onShopItemLongClickListener?.invoke(shopItem)
//            true
//        }
        binding.root.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
        }
    }

//    override fun getItemViewType(position: Int): Int {
//        val item = getItem(position)
//        return if (item.enabled) {
//            VIEW_TYPE_ENABLED
//        } else {
//            VIEW_TYPE_DISABLED
//        }
//    }

    companion object {

        const val VIEW_TYPE_ENABLED = 100
        const val VIEW_TYPE_DISABLED = 101

        const val MAX_POOL_SIZE = 30
    }

}