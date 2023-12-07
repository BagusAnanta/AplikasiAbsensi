package com.bsoftware.aplikasiabsensi.dateClass

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class GetDate {

    fun getDateNow() : String?{
        val date = LocalDate.now()
        val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        return date.format(dateFormatter)
    }
}