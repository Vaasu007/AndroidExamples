package com.ibm.firstg

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore.AUTHORITY
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.display_main.*
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter


class Display : AppCompatActivity() {






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_main)



        val hvList = intent.getStringArrayListExtra("horse_value");

        val gvList = intent.getStringArrayListExtra("guns_value");

        val mvList = intent.getStringArrayListExtra("mans_value");

        val avList = intent.getStringArrayListExtra("ammo_value");



        Log.d("TAG", hvList.toString() + gvList.toString() + mvList.toString() + avList.toString())
        Log.d("-->my path" , filesDir.path)
//        val mydispAdapter = MydisplayAdapter(this,mvList, hvList , gvList , avList )
//        listViewd.adapter = mydispAdapter


        var counter =0
        if(counter == 0){
        val fileObject = File(filesDir , "newdata.txt")
        fileObject.createNewFile()
        }
        val fileObject = File(filesDir , "newdata.txt")
        val writer = FileWriter(fileObject)



//        val bufferedReader = fileObject.bufferedReader()
//        val text = bufferedReader.readLines()
//        fileObject.forEachLine { println(it) }
//        val browserIntent = Intent(Intent.ACTION_VIEW)
//        browserIntent.addCategory(Intent.CATEGORY_BROWSABLE)
//        browserIntent.data = Uri.fromFile(fileObject)
//        startActivity(browserIntent)


        val textview1 = findViewById<TextView>(R.id.wman)
        val textview2 = findViewById<TextView>(R.id.wgun)
        val textview3 = findViewById<TextView>(R.id.whorse)
        val textview4 = findViewById<TextView>(R.id.wammo)

        textview1.text = mvList.toString()
        textview2.text = gvList.toString()
        textview3.text = hvList.toString()
        textview4.text = avList.toString()

        dispwrite.setOnClickListener(){

            writer.write(hvList.toString() + gvList.toString() + mvList.toString() + avList.toString() )
            writer.appendln()
            writer.close()
            counter++


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }




        dispb.setOnClickListener(){
            //                intent = Intent(this, MainActivity::class.java)
//                intent.putExtra("GunSelected", gunsList)
//                startActivity(intent)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
//        sendEmailBtn.setOnClickListener {
//            //get input from EditTexts and save in variables
//
//            mailslist.forEach {
//                val recipient = it
//                val subject = "Report for Duty".trim()
//                val message = ("Due to commencement of war you are requested to report for" +
//                        "duty to defend your nation.").trim()
//
//                //method call for email intent with these inputs as parameters
//                sendEmail(recipient, subject, message)
//
//            }
//        }
//    }
//
//    private fun sendEmail(recipient: String, subject: String, message: String) {
//        /*ACTION_SEND action to launch an email client installed on your Android device.*/
//        val mIntent = Intent(Intent.ACTION_SEND)
//        /*To send an email you need to specify mailto: as URI using setData() method
//        and data type will be to text/plain using setType() method*/
//        mIntent.data = Uri.parse("mailto:")
//        mIntent.type = "text/plain"
//        // put recipient email in intent
//        /* recipient is put as array because you may wanna send email to multiple emails
//           so enter comma(,) separated emails, it will be stored in array*/
//        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
//        //put the Subject in the intent
//        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
//        //put the message in the intent
//        mIntent.putExtra(Intent.EXTRA_TEXT, message)
//
//
//        try {
//            //start email intent
//            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
//        }
//        catch (e: Exception){
//            //if any thing goes wrong for example no email client application or any exception
//            //get and show exception message
//            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
//        }


    }
}