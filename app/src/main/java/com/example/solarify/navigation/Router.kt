package com.example.solarify.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen(val route: String) {
    object SignIn: Screen("SignIn")
    object SignUp: Screen("SignUp")
    object HomeScreen: Screen("HomeScreen")

}