package com.example.studentregistration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.studentregistration.ui.theme.StudentRegistrationTheme
import androidx.lifecycle.ViewModelProvider
import androidx.compose.material3.MaterialTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Surface

//removed unused imports and added the nav one plus safeDrawingPadding to remove the overlap between the UI and notifications bar

//DB imports
import com.example.studentregistration.view.StudentsViewModel

//New pages import
import com.example.studentregistration.view.HomePage
import com.example.studentregistration.view.RegistrationPage
import com.example.studentregistration.view.SearchPage


//I am no longer using the repo for practice, so the initialization of the navigation example, as well as the simpleForm
// were removed, I still leave the greeting since IDK how the previews work yet, and they look useful.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val StudentViewModel = ViewModelProvider(this)[StudentsViewModel::class.java]
            setContent {

                StudentRegistrationTheme {
                    Surface(
                        //this modifier and the imports to use it was provided by AI, see AI usage #2
                        modifier = Modifier.fillMaxSize().safeDrawingPadding(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        StudentNavigation(StudentViewModel)
                    }
                }
                //Commented out since I might want to tweak it later to learn how previews work.
    //                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
    //                    Greeting(
    //                        name = "Android",
    //                        modifier = Modifier.padding(innerPadding)
    //                    )
            }
        }
    }

// Sets up navigation between the three pages.
@Composable
fun StudentNavigation(viewModel: StudentsViewModel) {

    // Manages which screen is currently displayed.
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,

        // The first page displayed when the app opens.
        startDestination = "home"
    ) {

        // Homepage
        composable("home") {
            HomePage(navController)
        }

        // Registration form
        composable("register") {
            RegistrationPage(navController, viewModel)
        }

        // Student search form
        composable("search") {
            SearchPage(navController, viewModel)
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


//all of this code is provisional, not the final product, I've been experimenting with the repos available to understand how the modularity in Android Studio works.
