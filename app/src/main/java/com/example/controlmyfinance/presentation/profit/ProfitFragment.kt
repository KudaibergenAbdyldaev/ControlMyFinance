package com.example.controlmyfinance.presentation.profit

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.controlmyfinance.R
import com.example.controlmyfinance.databinding.FragmentProfitBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfitFragment : Fragment(R.layout.fragment_profit) {

    private val binding: FragmentProfitBinding by viewBinding()
    private val viewModel: ProfitViewModel by viewModel()
    private val listAdapter: ProfitAdapter by lazy {
        ProfitAdapter()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.getProfit().collect {
                listAdapter.submitList(it)
            }
        }
        binding.recyclerView.adapter = listAdapter
    }

}