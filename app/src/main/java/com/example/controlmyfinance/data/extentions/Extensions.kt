package com.example.controlmyfinance.data.extentions

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.saveFormattedDate(): String{
    val date = this
    val originalFormat: DateFormat = SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.US);
    val targetFormat: DateFormat =
        SimpleDateFormat("HH:mm dd-MMM-yyyy", Locale.US);
    val parsedDate: Date = originalFormat.parse(date);
    val formattedDate = targetFormat.format(parsedDate);
    return formattedDate
}