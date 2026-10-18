package com.example.studentregistration.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.studentregistration.Student


@Database(entities = [Student::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class StudentDatabase : RoomDatabase(){

    companion object {
        const val NAME = "Student_DB"
    }

    abstract fun getStudentDao() : com.example.studentregistration.db.StudentDao

}