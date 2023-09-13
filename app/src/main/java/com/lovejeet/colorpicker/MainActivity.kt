package com.lovejeet.colorpicker

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.graphics.Color
import android.icu.text.Transliterator.Position
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.arch.core.executor.DefaultTaskExecutor
import androidx.core.graphics.toColorInt
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.MaterialColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import com.github.dhaval2404.colorpicker.model.ColorSwatch
import com.lovejeet.colorpicker.databinding.ActivityMainBinding
import com.lovejeet.colorpicker.databinding.CoustomDialogBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var recyclerview : RecyclerViewClass
    var  dataClass = ArrayList<DataClass>()
    var colorCode1: String = ""
    var colorCode2: String = ""
    var number: Int = 0


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Singlton.sharedPrefsClass.initSharedPreference(this)
        colorCode1 = Singlton.sharedPrefsClass.getString("color1")
        colorCode2 = Singlton.sharedPrefsClass.getString("color2")
        number = Singlton.sharedPrefsClass.getInt("number")
        recyclerview = RecyclerViewClass()
        recyclerview.updateValues(number, colorCode1, colorCode2)
        binding.rvList.adapter = recyclerview
        binding.rvList.layoutManager = LinearLayoutManager(this)
        binding.colorPicker.setOnClickListener {
            var dialog = Dialog(this@MainActivity)
            var dialogBinding = CoustomDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.show()
            dialogBinding.etClr1.setOnClickListener {
                ColorPickerDialog
                    .Builder(this)                        // Pass Activity Instance
                    .setTitle("Pick Theme")            // Default "Choose Color"
                    .setColorShape(ColorShape.SQAURE)   // Default ColorShape.CIRCLE
                    .setDefaultColor("#ffffff")     // Pass Default Color
                    .setColorListener { color, colorHex ->
                        dialogBinding.etClr1.setText(colorHex)    // Handle Color Selection
                    }
                    .show()
            }
            dialogBinding.etClr2.setOnClickListener {
                ColorPickerDialog
                    .Builder(this)                        // Pass Activity Instance
                    .setTitle("Pick Theme")            // Default "Choose Color"
                    .setColorShape(ColorShape.SQAURE)   // Default ColorShape.CIRCLE
                    .setDefaultColor("#ffffff")     // Pass Default Color
                    .setColorListener { color, colorHex ->
                        dialogBinding.etClr2.setText(colorHex)    // Handle Color Selection
                    }
                    .show()

            }
            dialogBinding.btnSave.setOnClickListener {
                if (dialogBinding.etClr1.text.toString().isNullOrBlank()) {
                    dialogBinding.etClr1.error = "Enter Color Value"
                } else if (
                    dialogBinding.etClr2.text.toString().isNullOrBlank()
                ) {
                    dialogBinding.etClr2.error = "Enter color Value"
                } else if (
                    dialogBinding.etNumber.text.toString().isNullOrBlank()
                ) {
                    dialogBinding.etNumber.error = "Enter Number"
                } else {
                    Singlton.sharedPrefsClass.saveString(
                        "color1",
                        dialogBinding.etClr1.text.toString()
                    )
                    Singlton.sharedPrefsClass.saveString(
                        "color2",
                        dialogBinding.etClr2.text.toString()
                    )
                    Singlton.sharedPrefsClass.saveInt(
                        "number",
                        dialogBinding.etNumber.text.toString().toInt()
                    )

                    colorCode1 = Singlton.sharedPrefsClass.getString("color1")
                    colorCode2 = Singlton.sharedPrefsClass.getString("color2")
                    number = Singlton.sharedPrefsClass.getInt("number")
                    recyclerview.updateValues(number, colorCode1, colorCode2)
                    dialog.dismiss()
                }
            }


        }

    }
    }
