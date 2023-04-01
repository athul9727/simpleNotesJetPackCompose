package com.example.simplenotesjetpackcompose.utils

import java.text.SimpleDateFormat
import java.util.*



    fun Long.formalDate() : String{
        val date  = Date(this)
        val dateFormat = SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault())
        return  dateFormat.format(date)
    }


