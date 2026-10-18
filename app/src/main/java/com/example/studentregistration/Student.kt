package com.example.studentregistration
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)
    var id: Int =0,
    var StudentName : String,
    var Course: String,
    var Year : Int
)