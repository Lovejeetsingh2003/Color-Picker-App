package com.lovejeet.colorpicker

import com.github.dhaval2404.colorpicker.util.SharedPref

object Singlton {
    init{
        println("in singleton init")
    }
    val sharedPrefsClass: SharedPrefsClass = SharedPrefsClass()
}