package com.ibm.firstg


import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.display_list.view.*

class MydisplayAdapter(private val context: Activity, private val Man: ArrayList<String>,  private val Horse: ArrayList<String> , private val Guns: ArrayList<String> , private val Ammo: ArrayList<String>)
    : ArrayAdapter<String>(context, R.layout.display_list) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.display_list, null, true)
        val manText = rowView.findViewById(R.id.man) as TextView
        val gunText = rowView.findViewById(R.id.gun) as TextView
        val horseText = rowView.findViewById(R.id.gun) as TextView
        val ammoText = rowView.findViewById(R.id.gun) as TextView



        manText.text =  Man.toString()
        gunText.text = Guns.toString()
        horseText.text = Horse.toString()
        ammoText.text = Ammo.toString()


        return rowView
    }
}