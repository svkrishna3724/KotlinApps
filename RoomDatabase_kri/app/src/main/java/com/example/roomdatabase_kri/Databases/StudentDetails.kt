package com.example.roomdatabase_kri.Databases

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "studentDetails")
class StudentDetails (
    @PrimaryKey(autoGenerate = true)
    var stu_id:Int =0,
    var stu_name:String ="",
    var stu_age:Int =0



)
