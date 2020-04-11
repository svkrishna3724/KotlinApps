package com.example.intents_kri

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.intents_kri.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  databinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        databinding.submit.setOnClickListener { getData() }
    }

    private fun getData(){
        val data = databinding.username.text.toString()

        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("key",data)
        //startActivity(intent)

        startActivityForResult(intent,200)

        val toast : Toast = Toast.makeText(this,data,Toast.LENGTH_SHORT)
        toast.show()


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && data !=null){
            val r =data.getStringExtra("replaymsg")
            val toast : Toast = Toast.makeText(this,r,Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}
