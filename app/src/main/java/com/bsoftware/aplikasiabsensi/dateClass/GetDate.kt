package com.bsoftware.aplikasiabsensi.dateClass

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class GetDate {
    val currentDate = Date()

    // get date now
    fun getDateNow() : String? {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        return dateFormat.format(dateFormat)
    }


}