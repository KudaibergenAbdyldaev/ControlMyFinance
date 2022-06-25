package com.example.controlmyfinance.presentation.detail

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.controlmyfinance.databinding.DetailDialogBinding
import com.example.controlmyfinance.domain.model.Profit

class ProfitDetailDialog(
    context: Context,
    private val profit: Profit
) : Dialog(context) {

    private val binding: DetailDialogBinding by lazy {
        DetailDialogBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            comment.text = profit.comment
            sum.text = profit.sum.toString()
            amount.isVisible = false
            amountTxt.isVisible = false
            date.text = profit.date
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