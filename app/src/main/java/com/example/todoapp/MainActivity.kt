package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.navigation.SetupNavigation
import com.example.todoapp.ui.theme.TodoAppTheme
import com.example.todoapp.ui.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

// Indicates that Hilt should provide dependencies to this activity
@AndroidEntryPoint
// Extends ComponentActivity, which is a base class for activities that use Jetpack Compose
class MainActivity : ComponentActivity() {

    // Late initialization of NavHostController to manage navigation
    private lateinit var navController: NavHostController
    // Lazy instantiation of the ViewModel using Hilt
    private  val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        // Setting the content view of the activity to use Compose
        setContent {
            // Applying the custom theme for the app
            TodoAppTheme {
                // Initializing the NavHostController for managing navigation
                navController = rememberNavController()
                // Setting up the navigation graph with the navController and sharedViewModel
                SetupNavigation(
                    navController = navController,
                    sharedViewModel = sharedViewModel
                )
            }
        }
    }
}