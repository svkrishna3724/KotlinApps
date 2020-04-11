package com.example.databinding_kri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding_kri.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var databinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        // Displaying Toast Message

        /*val text = databinding.sample1.text

        var toast : Toast = Toast.makeText(this,text,Toast.LENGTH_SHORT)
        toast.show()*/

        databinding.setbutton.setOnClickListener { setName() }
    }

    private fun setName() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        // for getting text from the edittext
        val n = databinding.name.text.toString()

        //databinding.displayname.setText(n)

        //databinding.displayname.text = n

        val m1 : MyName = MyName(n)
        databinding.n = m1
        databinding.name.text.clear()

    }
}
