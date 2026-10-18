package com.example.studentregistration


import android.app.Application
import androidx.room.Room //fixed the import by the one used in Android Studio docs
import com.example.studentregistration.db.StudentDatabase


class MainApplication : Application() {

    companion object {
        //Shared db instance
        lateinit var studentDatabase: StudentDatabase
    }

    override fun onCreate() {
        super.onCreate()

        //create or open the db when the application runs

        studentDatabase = Room.databaseBuilder(
            applicationContext,
            StudentDatabase::class.java,
            StudentDatabase.NAME
        ).build()
    }

}