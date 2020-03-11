package com.ibm.firstg

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.display_main.*

class Display : AppCompatActivity() {






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_main)

        val bundle: Bundle? = intent.extras

        val hvList = intent.getStringArrayListExtra("horse_value");

        val gvList = intent.getStringArrayListExtra("guns_value");

        val mvList = intent.getStringArrayListExtra("mans_value");

        val avList = intent.getStringArrayListExtra("ammo_value");


        Log.d("TAG", hvList.toString() + gvList.toString() + mvList.toString() + avList.toString())

        val mydispAdapter = MydisplayAdapter(this,mvList, hvList , gvList , avList )
        listViewd.adapter = mydispAdapter

    }
}