package com.example.controlmyfinance.presentation.add_finance

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.controlmyfinance.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.controlmyfinance.databinding.FragmentAddFinanceBinding
import com.example.controlmyfinance.presentation.helper.handleOnBackPressed
import com.example.controlmyfinance.presentation.helper.navigateBack
import com.example.controlmyfinance.presentation.main.MainActivity
import com.example.controlmyfinance.presentation.show_finance.ShowFinanceFragment
import java.lang.RuntimeException

class AddFinanceFragment : Fragment(R.layout.fragment_add_finance) {

    private val binding: FragmentAddFinanceBinding by viewBinding()
    private val viewModel: AddFinanceViewModel by viewModel()

    private var mode = -1

    companion object {
        private const val MODE = "mode"

        fun initAddFinanceFr(position: Int): AddFinanceFragment {
            val fragment = AddFinanceFragment()
            val bundle = Bundle()
            bundle.putInt(MODE, position)
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateBack()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideKeyboardAndCleatFocus()
        initAddButton()
        initTitle()
        initBackButton()
        viewModel.setMode(arguments?.getInt(MODE) ?: -1)
    }

    private fun initAddButton() {
        binding.apply {
            add.setOnClickListener {
                viewModel.setFinance(commentEdt.text.toString(), sumEdt.text.toString().toDouble())
            }
        }
    }

    private fun initBackButton() {
        binding.back.setOnClickListener {
            (requireActivity() as MainActivity).navigateBack(
                ShowFinanceFragment.initFinanceFr(mode)
            )
        }
    }

    private fun navigateBack() {
        (requireActivity() as MainActivity).handleOnBackPressed(
            ShowFinanceFragment.initFinanceFr(arguments?.getInt(MODE) ?: -1)
        )
    }

    private fun initTitle() {
        viewModel.modeLiveData.observe(viewLifecycleOwner) {
            mode = it
            when (it) {
                0 -> {
                    binding.title.text = getString(R.string.expenses)
                }
                1 -> {
                    binding.title.text = getString(R.string.profit)
                }
                else -> {
                    throw RuntimeException("Unknown mode")
                }
            }
        }

    }

    private fun hideKeyboardAndCleatFocus() {
        binding.root.setOnClickListener {
            binding.commentEdt.clearFocus()
            binding.sumEdt.clearFocus()

            val imm: InputMethodManager =
                requireActivity().getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }

    }

}