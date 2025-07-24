package com.example.calisthenicsquest.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calisthenicsquest.ui.screen.auth.LoginScreen
import com.example.calisthenicsquest.ui.screen.auth.SignUpScreen
import com.example.calisthenicsquest.viewmodel.AuthViewModel

@Composable
fun AppNavGraph(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login"){
            LoginScreen(modifier, navController, authViewModel)
        }
        composable("signup"){
            SignUpScreen(modifier, navController, authViewModel)
        }
        composable("home"){
            HomeScreen(modifier)
        }
    })
}