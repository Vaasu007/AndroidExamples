package com.ibm.firstg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener {

    private val id: Int = 10

    private var horseList = arrayListOf<String>()

    private var gunsList = arrayListOf<String>()

    private var manList = arrayListOf<String>()

    private var emails = arrayListOf<String>()


    private var ammoList = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null){
            horseList = savedInstanceState.getStringArrayList("horse") as ArrayList<String>
            manList = savedInstanceState.getStringArrayList("Man") as ArrayList<String>
            gunsList = savedInstanceState.getStringArrayList("Gun") as ArrayList<String>
            ammoList = savedInstanceState.getStringArrayList("Ammo") as ArrayList<String>
        }

//
//        if( intent.getStringArrayListExtra("HorseSelected") != null ) horseList.addAll(intent.getStringArrayListExtra("HorseSelected"))
//        if( intent.getStringArrayListExtra("ManSelected") != null )   manList.addAll(intent.getStringArrayListExtra("ManSelected"))
//        if( intent.getStringArrayListExtra("GunSelected") != null )   gunsList.addAll(intent.getStringArrayListExtra("GunSelected"))
//        if(intent.getStringArrayListExtra("AmmoSelected")!= null )    ammoList.addAll(intent.getStringArrayListExtra("AmmoSelected"))

//        Log.d("TAG", "-->$horseList")
//        Toast.makeText(applicationContext,manList.toString(),Toast.LENGTH_LONG).show()

//        val GunsSelected = bundle?.get("GunsSelected")
//        gunsList.add(HorseSelected.toString())
//        Toast.makeText(applicationContext,GunsSelected.toString(),Toast.LENGTH_LONG).show()


    }

    override fun onResume() {
        super.onResume()

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)




    }
    override fun onSaveInstanceState(outState: Bundle) {
        if (outState != null) {

            super.onSaveInstanceState(outState)

            outState?.putStringArrayList("horse", horseList)
            outState?.putStringArrayList("Man", manList)
            outState?.putStringArrayList("Gun ", gunsList)
            outState?.putStringArrayList("Ammo", ammoList)


        }
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            horseList = savedInstanceState.getStringArrayList("horse") as ArrayList<String>
            manList = savedInstanceState.getStringArrayList("Man") as ArrayList<String>
            gunsList = savedInstanceState.getStringArrayList("Gun") as ArrayList<String>
            ammoList = savedInstanceState.getStringArrayList("Ammo") as ArrayList<String>
        }


    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            1 -> {
                if (data?.getStringArrayListExtra("GunSelected") != null)
                    gunsList.addAll(data.getStringArrayListExtra("GunSelected"))
                Log.d("Tag ", gunsList.toString())
            }

            2 -> {
                if (data?.getStringArrayListExtra("ManSelected") != null)
                    manList.addAll(data.getStringArrayListExtra("ManSelected"))
                if (data?.getStringArrayExtra("emails") != null) {
                    emails.addAll(data.getStringArrayExtra("emails"))
                }

                Log.d("Tag ", manList.toString())
                Log.d("Tag ", emails.toString())
            }

            3 -> {
                if (data?.getStringArrayListExtra("HorseSelected") != null)
                    horseList.addAll(data.getStringArrayListExtra("HorseSelected"))
                Log.d("Tag ", "-->$horseList")
            }
            4 -> {
                if (data?.getStringArrayListExtra("AmmoSelected") != null)
                    ammoList.addAll(data.getStringArrayListExtra("AmmoSelected"))
                Log.d("Tag ", ammoList.toString())
            }

        }
    }


    override fun onClick(view: View) {

        when (view.id) {
            R.id.button1 -> {
                intent = Intent(this, Guns::class.java)
                intent.putExtra("id_value", id)
                startActivityForResult(intent, 1)
            }


            R.id.button2 -> {
                intent = Intent(this, ManPower::class.java)
                intent.putExtra("id_value", id)
                startActivityForResult(intent, 2)
            }


            R.id.button3 -> {
                intent = Intent(this, Horse::class.java)
                intent.putExtra("id_value", id)
                startActivityForResult(intent, 3)
            }


            R.id.button4 -> {
                intent = Intent(this, Ammo::class.java)
                intent.putExtra("id_value", id)
                startActivityForResult(intent, 4)
            }

            R.id.button5 -> {
                intent = Intent(this, Display::class.java)
                intent.putExtra("horse_value", horseList)
                intent.putExtra("guns_value", gunsList)
                intent.putExtra("mans_value", manList)
                intent.putExtra("emails" , emails)
                intent.putExtra("ammo_value", ammoList)
                startActivity(intent)
            }
        }
    }

}