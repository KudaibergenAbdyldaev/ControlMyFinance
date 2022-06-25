package com.example.controlmyfinance.presentation.expenses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.controlmyfinance.R
import com.example.controlmyfinance.databinding.FragmentExpensesBinding
import com.example.controlmyfinance.domain.model.Expenses
import com.example.controlmyfinance.presentation.helper.setupSwipeListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class ExpensesFragment : Fragment(R.layout.fragment_expenses) {

    private val binding: FragmentExpensesBinding by viewBinding()
    private val viewModel: ExpensesViewModel by viewModel()
    private val listAdapter: ExpensesAdapter by lazy {
        ExpensesAdapter()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.getExpenses().collect {
                listAdapter.submitList(it)
            }
        }
        binding.recyclerView.adapter = listAdapter
        binding.recyclerView.setupSwipeListener { position ->
            val item = listAdapter.currentList[position]
            viewModel.delete(item)
        }
    }


}