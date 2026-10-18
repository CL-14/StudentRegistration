package com.example.studentregistration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.studentregistration.ui.theme.StudentRegistrationTheme
import androidx.lifecycle.ViewModelProvider
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.example.studentregistration.entities.Booking
import com.example.studentregistration.ui.theme.StudentRegistrationTheme
import com.example.studentregistration.view.StudentListPage
import kotlin.math.roundToInt


//imports for nav

//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.navArgument

//DB imports

import com.example.studentregistration.view.StudentsViewModel
import androidx.compose.material3.Surface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val StudentViewModel = ViewModelProvider(this)[StudentsViewModel::class.java]
            setContent {


                //comment out navar example testing
//            val navCont = rememberNavController()
//
//            NavHost(navController = navCont, startDestination = "Start", builder = {
//                composable(route = "Start")
//                {
//                    Start(navCont)
//                }
//                composable(
//                    route = "SecondScreen/{name}",
//                    arguments = listOf(navArgument("name") {
//                        type = NavType.StringType
//                    })
//                )
//                { backStackentry ->
//                    val uname =
//                        backStackentry.arguments?.getString("name") // Need to get value from here
//                    println(uname)
//                    SecondScreen(navCont, uname ?: "No name")
//                }
//            }) // End of NavHost


                StudentRegistrationTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        StudentListPage(StudentViewModel)
                    }

//                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                simpleForm()
                }
            }
        }
    }


    @Composable
    fun simpleForm() {
        //variables used to populate the form
        //"remember" and "mutable" is needed to update the forms
        var vol = 0
        var nameOfPerson by remember { mutableStateOf("") }
        var noOfDays by remember { mutableStateOf("") }
        var noOfPeople by remember { mutableStateOf("") }
        var bookingMessage by remember { mutableStateOf("") }
        //setting up a lazyColumn to assist with format

        LazyColumn() {
            item {
                Spacer(Modifier.padding(20.dp))

            }
            item {
                Row(Modifier.padding(20.dp)) {
                    Text("Enter Name... \t")
                    TextField(
                        value = nameOfPerson, //initial value
                        onValueChange = { nameOfPerson = it }
                    )
                }

            }
            item {
                Row(Modifier.padding(20.dp)) {
                    Text("Enter number of People... \t")
                    TextField(
                        value = noOfPeople, //initial value
                        onValueChange = { noOfPeople = it }
                    )
                }

            }
            item {
                Row(Modifier.padding(20.dp)) {
                    Text("Enter number of days... \t")
                    TextField(
                        value = noOfDays, //initial value
                        onValueChange = { noOfDays = it }
                    )
                }

            }
            item {
                Spacer(Modifier.size(20.dp))
                Row(
                    Modifier.padding(30.dp)
                ) {
                    Button(onClick = {
                        println("Name " + nameOfPerson)
                        println("Number of Days " + noOfDays)
                        println("Number of people " + noOfPeople)
                        //create an instance of Booking
                        val bookOne = Booking(nameOfPerson, noOfPeople.toInt(), noOfDays.toInt())
                        //calling CalculateAmt functions
                        println(bookOne.CalculateAmt())
                        nameOfPerson = ""
                        noOfDays = ""
                        noOfPeople = ""
                    }) {
                        Text(text = "Make Booking")
                    }
                }
            }

        }

    }

//this is the composable responsible for generating the message.

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }


    //this shows a preview of what I did when I split the screen!!
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        StudentRegistrationTheme {
            Greeting("Android")
        }
    }
}

//all of this code is provisional, not the final product, I've been experimenting with the repos available to understand how the modularity in Android Studio works.
