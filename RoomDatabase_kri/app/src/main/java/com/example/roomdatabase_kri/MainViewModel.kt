package com.example.roomdatabase_kri

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roomdatabase_kri.Databases.StudentDetails
import com.example.roomdatabase_kri.Databases.StudentRepository

class MainViewModel(application:Application):AndroidViewModel(application) {
    val studentRepository : StudentRepository
    val allStudents : LiveData<List<StudentDetails>>

 init {
     studentRepository = StudentRepository(application)
     allStudents = studentRepository.getAll()
 }
    fun insert(studentDetails: StudentDetails){
        studentRepository.insert(studentDetails)
    }
}