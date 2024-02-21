package com.example.solarify.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.ActivityNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.solarify.screens.HomeScreen
import com.example.solarify.screens.SignIn
import com.example.solarify.screens.SignUp

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SignIn.route){
        composable(Screen.SignUp.route){ SignUp(navController)}
        composable(Screen.SignIn.route){ SignIn(navController)}
        composable(Screen.HomeScreen.route){ HomeScreen()}
    }
}