package com.example.studentregistration.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.studentregistration.Student
import com.example.studentregistration.MainApplication
import java.time.Instant
import java.util.Date

class StudentsViewModel : ViewModel() {
    val StudentDao by lazy{
        MainApplication.StudentDatabase.getStudentDao()
    }
    val StudentList: LiveData<List<Student>> by lazy{
    StudentDao.getAllStudents()
    }

    fun addStudent(StudentName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            StudentDao.addStudent(
                Student(
                    StudentName = StudentName, Course = "Math", Year = 2026

                )
            )
        }
    }

    fun deleteStudent(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            StudentDao.deleteStudent(id)
        }
    }
    fun searchStudent(id: Int): LiveData<Student> {
        return StudentDao.searchStudent(id)
    }
}






