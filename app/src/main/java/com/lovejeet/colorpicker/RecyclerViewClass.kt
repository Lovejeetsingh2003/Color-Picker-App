package com.lovejeet.colorpicker

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewClass() : RecyclerView.Adapter<RecyclerViewClass.TextViewHolder>(){
    var number : Int = 0
    var color1: String = ""
    var color2 : String = ""

    @SuppressLint("NotifyDataSetChanged")
    fun updateValues(number : Int, color1: String, color2: String){
        this.color1 = color1
        this.color2 = color2
        this.number = number
        notifyDataSetChanged()
    }
    class TextViewHolder( view: View) : RecyclerView.ViewHolder(view){
        var name = view.findViewById<TextView>(R.id.tvText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewClass.TextViewHolder {
        return TextViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false))
    }


    override fun getItemCount(): Int {
        return number
    }

    override fun onBindViewHolder(holder: RecyclerViewClass.TextViewHolder, position: Int) {
        if(position % 2 == 0){
            holder.name.setBackgroundColor(Color.parseColor(color1))
        }else{
            holder.name.setBackgroundColor(Color.parseColor(color2))
        }
    }

}