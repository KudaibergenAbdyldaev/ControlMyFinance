package com.example.controlmyfinance.presentation.expenses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.controlmyfinance.R
import com.example.controlmyfinance.databinding.FragmentExpensesBinding

class ExpensesFragment : Fragment(R.layout.fragment_expenses) {

    private val binding: FragmentExpensesBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}