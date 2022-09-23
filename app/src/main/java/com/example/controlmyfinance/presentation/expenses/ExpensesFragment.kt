package com.example.controlmyfinance.presentation.expenses

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.controlmyfinance.R
import com.example.controlmyfinance.databinding.FragmentExpensesBinding
import com.example.controlmyfinance.presentation.detail.ExpensesDetailDialog
import com.example.controlmyfinance.presentation.helper.setupSwipeListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class ExpensesFragment : Fragment(R.layout.fragment_expenses) {

    private val binding: FragmentExpensesBinding by viewBinding()
    private val viewModel: ExpensesViewModel by viewModel()
    private val listAdapter: ExpensesAdapter by lazy {
        ExpensesAdapter()
    }

    private lateinit var database: DatabaseReference


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = FirebaseDatabase.getInstance("https://controlmyfinance-f244d-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();


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
        listAdapter.onItemClickListener = {
            var sum = 0.0

            listAdapter.currentList.forEach {
                sum += it.sum
            }
            Log.e("getTotalSum", sum.toString())
            ExpensesDetailDialog(requireActivity(), it).show()
        }

    }


}