package com.example.studentregistration


import android.app.Application
import androidx.room.Room.databaseBuilder
import com.example.studentregistration.db.StudentDatabase
import com.example.studentregistration.Student


class MainApplication : Application() {

    companion object {
        lateinit var StudentDatabase: StudentDatabase // Creating our database object
    }

    override fun onCreate() {
        super.onCreate()



        Companion.StudentDatabase = databaseBuilder(
            applicationContext,
            com.example.studentregistration.db.StudentDatabase::class.java,
            com.example.studentregistration.db.StudentDatabase.NAME
        ).build()
    }

}