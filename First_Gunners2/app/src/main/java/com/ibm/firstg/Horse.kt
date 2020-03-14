package com.ibm.firstg

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.horse_list.*


class Horse  : AppCompatActivity()  {

    private val description = arrayOf<String>(
        "Horse1" , "Horse2 " , " Horse3 " , "Horse4"
    )

    private val imageId = arrayOf<Int>(
        R.drawable.horse, R.drawable.horse1 ,  R.drawable.horse2 , R.drawable.horse3
    )
    private val hList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.horse_list)
    }

    override fun onResume() {
        super.onResume()

        val myListAdapter = MyListAdapter(this,description,imageId)
        listViewh.adapter = myListAdapter

        listViewh.setOnItemClickListener() { adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            hList.add(itemAtPos.toString())
//            Log.d("TAG", hList[0])
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


            horseb.setOnClickListener(){
//                intent = Intent(this, MainActivity::class.java)
//                intent.putExtra("HorseSelected", hList)
//                startActivity(intent)
                val intent = Intent()
                intent.putExtra("HorseSelected", hList)
                setResult(3, intent)
                finish()//finishing activity

            }


        }
    }

