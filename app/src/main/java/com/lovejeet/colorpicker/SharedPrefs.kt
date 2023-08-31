package com.lovejeet.colorpicker

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.github.dhaval2404.colorpicker.util.SharedPref

class SharedPrefs {
    var sharedPreferences : SharedPreferences ?= null
    var editor : SharedPreferences.Editor ?= null

    fun initPrefs(context:Context){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences(
                context.resources.getString(R.string.app_name),
                Context.MODE_PRIVATE)
            editor = sharedPreferences?.edit()

        }
    }
}