package com.lovejeet.colorpicker

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.icu.text.Transliterator.Position
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.dhaval2404.colorpicker.MaterialColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import com.github.dhaval2404.colorpicker.model.ColorSwatch
import com.lovejeet.colorpicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var binding: ActivityMainBinding
    var colorcode : String ?=null
    lateinit var recyclerview : RecyclerViewClass
    var dataClass = ArrayList<DataClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        recyclerview = RecyclerViewClass(dataClass)
        binding.list.layoutManager = LinearLayoutManager(this)
        binding.list.adapter = recyclerview
        sharedPreferences = getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
        val getColorCode = sharedPreferences.getString("COLORCODE" , "")
        setContentView(binding.root)
        binding.colorPicker.setOnClickListener {
            // Kotlin Code
            MaterialColorPickerDialog
                .Builder(this)        					// Pass Activity Instance
                .setTitle("Pick Theme")           		// Default "Choose Color"
                .setColorShape(ColorShape.SQAURE)   	// Default ColorShape.CIRCLE
                .setColorSwatch(ColorSwatch._300)   	// Default ColorSwatch._500
                .setDefaultColor(R.color.white) 		// Pass Default Color
                .setColorListener { color, colorHex ->
                    colorcode = colorHex
                }
                .show()
        }
        if(colorcode == null)
        {
            editor = sharedPreferences.edit()
            editor.putString("COLORCODE",colorcode)
            editor.apply()
        }
    }
}