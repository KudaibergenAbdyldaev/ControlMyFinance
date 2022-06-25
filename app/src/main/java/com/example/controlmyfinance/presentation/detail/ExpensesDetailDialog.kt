package com.example.controlmyfinance.presentation.detail

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import com.example.controlmyfinance.databinding.DetailDialogBinding
import com.example.controlmyfinance.domain.model.Expenses

class ExpensesDetailDialog(
    context: Context,
    private val expenses: Expenses
) : Dialog(context) {

    private val binding: DetailDialogBinding by lazy {
        DetailDialogBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            comment.text = expenses.comment
            sum.text = expenses.sum.toString()
            amount.text = expenses.amount.toString()
            date.text = expenses.date
            buttonClose.setOnClickListener { dismiss() }
        }
        setupUI()
    }

    private fun setupUI() {
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val back = ColorDrawable(Color.TRANSPARENT)
        val inset = InsetDrawable(back, 50, 0, 50, 0)
        window?.setBackgroundDrawable(inset)
        window?.setGravity(Gravity.CENTER)
    }
}