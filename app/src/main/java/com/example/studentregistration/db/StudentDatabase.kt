package com.example.studentregistration.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.studentregistration.Student


//this defines the db and the entities it stores
@Database(entities = [Student::class], version = 1, exportSchema = false)

//I don't need the converters anymore since I am not following the repos examples, so they are now deleted.



abstract class StudentDatabase : RoomDatabase(){

    // gives  access to the DAOs database
    abstract fun getStudentDao(): StudentDao

    companion object {
        // Name of the database
        const val NAME = "Student_DB"
    }

}