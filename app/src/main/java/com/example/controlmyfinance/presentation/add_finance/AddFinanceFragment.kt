package com.example.controlmyfinance.presentation.add_finance

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.controlmyfinance.R
import com.example.controlmyfinance.databinding.FragmentAddFinanceBinding

class AddFinanceFragment : Fragment(R.layout.fragment_add_finance) {

    private val binding: FragmentAddFinanceBinding by viewBinding()
    private val viewModel: AddFinanceViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}