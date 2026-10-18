package com.example.studentregistration.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.studentregistration.Student

/*
DAO Class is to form a bridge between the DataBase and the object
classes used in the app. Basically sets the operations I want to perform on the db
 */
@Dao
interface StudentDao {

    //Insert one student into the database
    @Insert
    suspend fun addStudent(student: Student): Long

    //Find one student using their ID
    //Returns null if no student with the ID exists.
    @Query("SELECT * FROM Student WHERE id = :id LIMIT 1")
    suspend fun searchStudent(id: Int): Student?

}


//I keep the references, so I don't get lost with the imports since they are from bimalkaf for now, I am just adapting it
/**
 * References :
 *
 * Downloaded this repo to see examples of several Android concepts
 * https://github.com/bimalkaf/JetpackCompose_Playground/tree/main
 *
 * Specific Repo where this code is stored
 * https://github.com/bimalkaf/JetpackCompose_Playground/tree/main/4_TodoApp_RoomDB
 */