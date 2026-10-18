package com.example.studentregistration.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.studentregistration.Student

/*
DAO Class is to form a bridge between the DataBase and the object
classes used in the app.
 */
@Dao
interface StudentDao {
    /*
    Annotations needed to specify the SQL queries type
     */
    @Query("SELECT * FROM Student ORDER BY id DESC")
    fun getAllStudents() : LiveData<List<Student>>

    @Insert
    fun addStudent(todo : Student)

    @Query("Delete FROM Student where id = :id")
    fun deleteStudent(id : Int)

    @Query("SELECT * FROM Student where id = :id")
    fun searchStudent(id : Int):LiveData<Student>

}

/**
 * References :
 *
 * Downloaded this repo to see examples of several Android concepts
 * https://github.com/bimalkaf/JetpackCompose_Playground/tree/main
 *
 * Specific Repo where this code is stored
 * https://github.com/bimalkaf/JetpackCompose_Playground/tree/main/4_TodoApp_RoomDB
 */