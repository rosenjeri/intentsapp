package com.example.morningintentsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var buttonsms :Button ?=null
    var buttonEmail :Button ?=null
    var buttonCamera :Button ?=null
    var buttonshare :Button ?=null
    var buttoncall :Button ?=null
    var buttonmpesa :Button ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonsms =findViewById(R.id.mbtnsms)
        buttonEmail =findViewById(R.id.mbtnemail)
        buttonCamera =findViewById(R.id.mbtncamera)
        buttonshare =findViewById(R.id.mbtnshare)
        buttoncall =findViewById(R.id.mbtncall)
        buttonmpesa =findViewById(R.id.mbtnmpesa)

        buttonsms!!.setOnClickListener {
            val uri = Uri.parse("smsto:YOUR_SMS_NUMBER")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "The SMS text")
            startActivity(intent)
        }
        buttonmpesa!!.setOnClickListener {

        }
        buttonCamera!!.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }
        buttonEmail!!.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }
        buttonshare!!.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            startActivity(shareIntent)
        }
        buttoncall!!.setOnClickListener {

        }
    }
}