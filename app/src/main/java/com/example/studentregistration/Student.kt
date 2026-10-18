package com.example.studentregistration
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Student(
    //auto generate the id for each entry!
    @PrimaryKey(autoGenerate = true)
    var id: Int =0,

    //this will be information entered in the registration form
    var StudentName : String,
    var Course: String,
    var Year : Int
)