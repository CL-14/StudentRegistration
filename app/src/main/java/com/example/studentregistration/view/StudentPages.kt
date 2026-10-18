package com.example.studentregistration.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.studentregistration.Student


//this is the homepage

@Composable
fun HomePage(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Student Registration Application")

        Spacer(modifier = Modifier.height(24.dp))

        // Navigate to the registration form
        Button(
            onClick = { navController.navigate("register") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Register Student")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Navigate to the student search page.
        Button(
            onClick = { navController.navigate("search") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search Student")
        }
    }
}


// registe rpage

@Composable
fun RegistrationPage(
    navController: NavHostController,
    viewModel: StudentsViewModel
) {
    // These variables hold what the user types.
    var name by remember { mutableStateOf("") }
    var course by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }

    // Display validation errors and success messages here.
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Register a Student")

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Student Name") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = course,
            onValueChange = { course = it },
            label = { Text("Course") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = year,
            onValueChange = { year = it },
            label = { Text("Year (1-4)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Button(
            onClick = {
                // Check that the name and course aren't empty.
                if (name.isBlank() || course.isBlank()) {
                    message = "Please enter a name and course."
                } else {
                    // Convert the year from text to an integer.
                    val yearNumber = year.toIntOrNull()

                    // Reject non-numbers and years outside 1-4.
                    if (yearNumber == null ||
                        yearNumber !in 1..4
                    ) {
                        message = "Year must be a number from 1 to 4."
                    } else {
                        // Only valid information reaches the database.
                        viewModel.addStudent(
                            name = name.trim(),
                            course = course.trim(),
                            year = yearNumber
                        ) {
                            // Clear the form after registration.
                            name = ""
                            course = ""
                            year = ""
                            message = "Student registered successfully. I hope"
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Register")
        }

        // Show validation errors or the success message.
        Text(message)

        Button(
            onClick = { navController.popBackStack() }
        ) {
            Text("Back")
        }
    }
}


// Student search

@Composable
fun SearchPage(
    navController: NavHostController,
    viewModel: StudentsViewModel
) {
    var studentId by remember { mutableStateOf("") }

    // Store the student returned by the database, if any.
    var foundStudent by remember { mutableStateOf<Student?>(null) }

    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Search for a Student")

        OutlinedTextField(
            value = studentId,
            onValueChange = { studentId = it },
            label = { Text("Student ID") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Button(
            onClick = {
                // Convert the entered ID into an integer.
                val id = studentId.toIntOrNull()

                if (id == null || id <= 0) {
                    foundStudent = null
                    message = "Please enter a valid student ID. This app starts counting at 1 like normal people!"
                } else {
                    // Reset previous results while searching.
                    foundStudent = null
                    message = "Searching..."

                    viewModel.searchStudent(id) { student ->
                        if (student == null) {
                            message = "No student found with ID $id. :("
                        } else {
                            foundStudent = student
                            message = ""
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search")
        }

        // Display the student's details if anything was found
        foundStudent?.let { student ->
            Text("Student ID: ${student.id}")
            Text("Name: ${student.StudentName}")
            Text("Course: ${student.Course}")
            Text("Year: ${student.Year}")
        }

        // If no student was found, display an appropriate message
        if (message.isNotBlank()) {
            Text(message)
        }

        Button(
            onClick = { navController.popBackStack() }
        ) {
            Text("Back")
        }
    }
}
