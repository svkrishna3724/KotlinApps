package com.example.implicitintents_kri

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openProfile(view: View) {
        val i = Intent()
        i.setAction(ACTION_VIEW)
        i.setData(Uri.parse("https://svkrishna3724.github.io"))
        startActivity(i)
    }

    fun openCamera(view: View) {
        val i = Intent()
        i.setAction(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(i, 90)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
        }
    }
}

