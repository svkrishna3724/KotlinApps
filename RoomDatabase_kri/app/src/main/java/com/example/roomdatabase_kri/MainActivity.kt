package com.example.roomdatabase_kri

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase_kri.Databases.StudentDao
import com.example.roomdatabase_kri.Databases.StudentDatabase
import com.example.roomdatabase_kri.Databases.StudentDetails

class MainActivity : AppCompatActivity() {
    lateinit var stu_name:EditText
    lateinit var stu_age:EditText
    //lateinit var result_tv:TextView
    //lateinit var  studentDatabase: StudentDatabase
    lateinit var mainViewModel: MainViewModel
    lateinit var  recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        mainViewModel =  ViewModelProvider(this,MainViewModelFactory(application))
            .get(MainViewModel::class.java)

        mainViewModel.allStudents.observe(this, Observer { list ->
            displayData(list)
        })
    }
            private fun initViews() {
               stu_name = findViewById(R.id.sname)
               stu_age = findViewById(R.id.sage)
              // result_tv = findViewById(R.id.result)
                recyclerView = findViewById(R.id.recyclerview1)
    }

   /* fun savedata(view: View) {
        val n = stu_name.text.toString()
        val a : Int = (stu_age.text.toString()).toInt()
        val studentDetails : StudentDetails = StudentDetails(stu_name = n,stu_age = a)
      *//* val studentDetails : StudentDetails= StudentDetails(stu_name=n,stu_age=a)
       // val studentDetails : StudentDetails = StudentDetails(stu_name=n,stu_age = a)
       // val studentDatabase = StudentDatabase.getInstance(this)
        //studentDatabase.studentDao.insert(studentDetails)*//*
        mainViewModel.insert(studentDetails)
        Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show()
        stu_name.setText("")
        stu_age.setText("")
        stu_name.clearFocus()
        stu_age.clearFocus()


       //  displayData()
    }*/

    private fun displayData(list: List<StudentDetails>) {
        val ra = RecyclerAdapter(this,list)
        recyclerView.adapter =ra

     /*//   val list : List<StudentDetails>=studentDatabase.studentDao.getAll()
        result_tv.text = ""
        for(i in list){
            result_tv.append(""+i.stu_id+" "+i.stu_name+" "+i.stu_age+"\n\n\n")*/

        }
    class RecyclerAdapter(context: Context, val l:List<StudentDetails>) :ListAdapter<StudentDetails,RecyclerViewHolder>(StudentDiffutil()){

        class StudentDiffutil :DiffUtil.ItemCallback<StudentDetails>(){
            override fun areItemsTheSame(
                oldItem: StudentDetails,
                newItem: StudentDetails
            ): Boolean {
                return oldItem.stu_id ==newItem.stu_id

            }

            override fun areContentsTheSame(
                oldItem: StudentDetails,
                newItem: StudentDetails
            ): Boolean {
              return oldItem == newItem
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
            TODO("Not yet implemented")
            val v : View = LayoutInflater.from(context).inflate(R.layout.one_row,parent,false)

        }

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }

        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
            TODO("Not yet implemented")
            holder.stu_id :TextView! =itemView.findViewById<TextView>
        }
    }
    class RecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val stu_id :TextView! =itemView.findViewById(R.id.stu_id)

    }

    fun saveData(view: View) {
        val n = stu_name.text.toString()
        val a : Int = (stu_age.text.toString()).toInt()
        val studentDetails : StudentDetails = StudentDetails(stu_name = n,stu_age = a)
        mainViewModel.insert(studentDetails)
        Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show()
        stu_name.setText("")
        stu_age.setText("")
        stu_name.clearFocus()
        stu_age.clearFocus()
    }
}
