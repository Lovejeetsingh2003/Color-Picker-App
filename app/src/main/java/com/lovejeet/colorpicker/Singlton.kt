package com.lovejeet.colorpicker

import com.github.dhaval2404.colorpicker.util.SharedPref

class Singlton {
    init{
        println("in singleton init")
    }
    val sharedPref : SharedPrefs = SharedPrefs()

}