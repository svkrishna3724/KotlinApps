package com.example.intents_kri

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.intents_kri.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var databinding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_second)
        /*val bundle:Bundle? = intent.extras
       val res= bundle?.getString("key")*/
        val s = intent.getStringExtra("key")
        val toast:Toast = Toast.makeText(this,s,Toast.LENGTH_SHORT)
        toast.show()

        databinding.receivedata.text = s

        databinding.replaybutton.setOnClickListener { giveReplay() }


    }

    fun giveReplay(){
        val rv = databinding.replay.text.toString()
        val i = Intent()
        i.putExtra("replaymsg",rv)
        setResult(Activity.RESULT_OK,i)
        finish()



    }
}
