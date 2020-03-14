package com.ibm.firstg

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.manpower_list.*
import kotlinx.android.synthetic.main.custom_list.*



class ManPower  : AppCompatActivity()  {

    private val description = arrayOf<String>(
      "Person1" , "Person 2 " , " Person 3 " , "Person 4"
    )


    private val imageId = arrayOf<Int>(
     R.drawable.army , R.drawable.soldier ,  R.drawable.army , R.drawable.soldier
    )
    private val personList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.manpower_list)

    }

    override fun onResume() {
        super.onResume()

        val myListAdapter = MyListAdapter(this,description,imageId)
        listViewv.adapter = myListAdapter

        listViewv.setOnItemClickListener() { adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)

            personList.add(itemAtPos.toString())

            Toast.makeText(
                this,
                "Click on item at $itemAtPos its item id $itemIdAtPos",
                Toast.LENGTH_LONG
            ).show()

        }


//            val bundle: Bundle? = intent.extras
//            val id = bundle?.get("id_value")
//            val language = bundle?.get("language_value")
//            Toast.makeText(applicationContext,id.toString()+" "+language, Toast.LENGTH_LONG).show()

        Manb.setOnClickListener(){
//            intent = Intent(this,MainActivity::class.java)
//
//            intent.putExtra("ManSelected", personList)
//            startActivity(intent)
            val intent = Intent()
            intent.putExtra("ManSelected", personList)
            setResult(2, intent)
            finish() //finis

        }


        }
    }

