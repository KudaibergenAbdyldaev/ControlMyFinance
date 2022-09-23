package com.example.controlmyfinance.presentation.add_finance

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.controlmyfinance.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.controlmyfinance.databinding.FragmentAddFinanceBinding

class AddFinanceFragment : Fragment(R.layout.fragment_add_finance) {

    private val binding: FragmentAddFinanceBinding by viewBinding()
    private val viewModel: AddFinanceViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setOnClickListener {
            hideKeyboardAndCleatFocus()
        }
        initAddButton()
        initSuccessAdded()
        initActiveButton()
        initPlusButton()
        initMinusButton()
    }

    private fun initAddButton() {
        binding.apply {
            add.setOnClickListener {
                viewModel.setFinance(
                    commentEdt.text.toString(),
                    sumEdt.text.toString().toDouble(),
                    binding.amount.text.toString().toInt()
                )
            }
        }
    }

    private fun initPlusButton() {
        var i: Int
        binding.apply {
            plus.setOnClickListener {
                i = amount.text.toString().toInt()
                i++
                amount.text = i.toString()
            }
        }
    }

    private fun initMinusButton() {
        var i: Int
        binding.apply {
            minus.setOnClickListener {
                i = amount.text.toString().toInt()
                if (i > 1) {
                    i--
                    amount.text = i.toString()
                }
            }
        }
    }

    private fun initActiveButton() {
        binding.apply {
            add.isEnabled =
                commentEdt.text.toString().isNotBlank() && sumEdt.text.toString().isNotBlank()
            commentEdt.doAfterTextChanged {
                add.isEnabled =
                    it.toString().isNotBlank() && sumEdt.text.toString().isNotBlank()
            }
            sumEdt.doAfterTextChanged {
                add.isEnabled =
                    it.toString().isNotBlank() && commentEdt.text.toString().isNotBlank()
            }
        }
    }

    private fun initSuccessAdded() {
        viewModel.isSuccessLiveData.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(requireActivity(), "Success Added", Toast.LENGTH_SHORT).show()
                binding.apply {
                    commentEdt.text?.clear()
                    sumEdt.text?.clear()

                    hideKeyboardAndCleatFocus()
                }
                viewModel.clearIsSuccess()
            }
        }
    }

    private fun clearFocus() {
        binding.commentEdt.clearFocus()
        binding.sumEdt.clearFocus()
    }

    private fun hideKeyboardAndCleatFocus() {
        clearFocus()
        val imm: InputMethodManager =
            requireActivity().getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

}