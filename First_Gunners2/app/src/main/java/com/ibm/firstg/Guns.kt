package com.ibm.firstg

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.guns_list.*





class Guns  : AppCompatActivity() {

    private val description = arrayOf<String>(
        "Gun1", "Gun2 ", " Gun3 ", "Gun4"
    )

    private val imageId = arrayOf<Int>(
        R.drawable.gun, R.drawable.smg, R.drawable.revolver, R.drawable.gun
    )
    private val gunsList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guns_list)
    }

    override fun onResume() {
        super.onResume()

        val myListAdapter = MyListAdapter(this, description, imageId)
        listViewg.adapter = myListAdapter

        listViewg.setOnItemClickListener() { adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)

            gunsList.add(itemAtPos.toString())

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

    gunb.setOnClickListener()
    {
//                intent = Intent(this, MainActivity::class.java)
//                intent.putExtra("GunSelected", gunsList)
//                startActivity(intent)
        val intent = Intent()
        intent.putExtra("GunSelected", gunsList)
        setResult(1, intent)
        finish()
    }

}
}


