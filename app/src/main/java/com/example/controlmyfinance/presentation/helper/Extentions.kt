package com.example.controlmyfinance.presentation.helper

import android.app.Dialog
import android.content.DialogInterface
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun RecyclerView.setupSwipeListener(swiped: ((Int) -> Unit)) {

    val callback = object : ItemTouchHelper.SimpleCallback(
        0,
        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
    ) {

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val alertDialog =
                MaterialAlertDialogBuilder(this@setupSwipeListener.context)
                    .setMessage("Are you want to delete?")
                    .setNegativeButton(
                        "NO"
                    ) { dialogInterface, _ ->
                        dialogInterface.dismiss()
                    }.setPositiveButton("YES") { dialogInterface, _ ->
                        swiped.invoke(viewHolder.bindingAdapterPosition)
                        dialogInterface.dismiss()
                    }
            alertDialog.show()
        }
    }
    val itemTouchHelper = ItemTouchHelper(callback)
    itemTouchHelper.attachToRecyclerView(this)
}