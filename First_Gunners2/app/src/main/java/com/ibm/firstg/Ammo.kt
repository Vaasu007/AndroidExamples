package com.ibm.firstg

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.ammo_list.*





class Ammo  : AppCompatActivity()  {

    val description = arrayOf<String>(
        "Ammo1" , "Ammo2 " , " Ammo3 " , "Ammo4"
    )

    val imageId = arrayOf<Int>(
        R.drawable.ammo, R.drawable.ammo ,  R.drawable.ammo , R.drawable.ammo
    )
    private val ammoList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ammo_list)

        val myListAdapter = MyListAdapter(this,description,imageId)
        listViewa.adapter = myListAdapter

        listViewa.setOnItemClickListener(){adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)

            ammoList.add(itemAtPos.toString())

            Toast.makeText(this, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_LONG).show()



//            val bundle: Bundle? = intent.extras
//            val id = bundle?.get("id_value")
//            val language = bundle?.get("language_value")
//            Toast.makeText(applicationContext,id.toString()+" "+language, Toast.LENGTH_LONG).show()

            ammob.setOnClickListener(){
//
//                intent = Intent(this, MainActivity::class.java)
//
//                intent.putExtra("AmmoSelected", ammoList)
//                startActivity(intent)
                val intent = Intent()
                intent.putExtra("AmmoSelected", ammoList)
                setResult(4, intent)
                finish() //finishin
            }


        }
    }

}