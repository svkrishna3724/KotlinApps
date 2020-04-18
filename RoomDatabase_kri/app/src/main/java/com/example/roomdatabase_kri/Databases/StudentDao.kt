package com.example.roomdatabase_kri.Databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabase_kri.Databases.StudentDetails
@Dao
interface StudentDao {
    @Insert
    fun insert(StudentDetails:StudentDetails)
    @Query("select * from studentDetails")
    fun getAll():LiveData<List<StudentDetails>>
}